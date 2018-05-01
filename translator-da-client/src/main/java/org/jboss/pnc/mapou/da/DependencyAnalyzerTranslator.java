package org.jboss.pnc.mapou.da;

import lombok.Getter;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.tls.OkHostnameVerifier;
import org.jboss.pnc.mapou.common.dependencies.InternalDependency;
import org.jboss.pnc.mapou.common.dependencies.PublicDependency;
import org.jboss.pnc.mapou.common.modes.Mode;
import org.jboss.pnc.mapou.common.translator.ITranslator;
import org.jboss.pnc.mapou.da.mode.IModeInfo;
import org.jboss.pnc.mapou.da.mode.ModeInfoFactory;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class DependencyAnalyzerTranslator implements ITranslator {

    @Getter
    private final String serverUrl;

    private final OkHttpClient httpClient;

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public DependencyAnalyzerTranslator(String serverUrl) {
        this.serverUrl = serverUrl;

        httpClient = new OkHttpClient();
    }

    public Map<PublicDependency, InternalDependency> translateVersions(Mode mode, Set<PublicDependency> publicDeps) throws IOException  {

        IModeInfo modeInfo = ModeInfoFactory.getInstance(mode);

        Request request = generateRequest(modeInfo, publicDeps);

        Response response = httpClient.newCall(request).execute();

        // TODO: improve this
        try {
            return modeInfo.parseResponse(response.body().bytes());
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }


    private Request generateRequest(IModeInfo modeInfo, Set<PublicDependency> publicDeps) {

        String jsonBody = modeInfo.generateJsonRequestString(publicDeps);

        RequestBody body = RequestBody.create(JSON, jsonBody);

        String endpoint = modeInfo.getDAEndpoint();

        Request request = new Request.Builder()
                .url(serverUrl + endpoint)
                .post(body)
                .build();

        return request;
    }
}
