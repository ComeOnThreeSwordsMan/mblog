package mblog.base.oauth.utils;

import java.security.cert.X509Certificate;

/**
 * @author an
 */
class MyX509TrustManager implements javax.net.ssl.X509TrustManager {
    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType)
            throws java.security.cert.CertificateException {
    }
    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType)
            throws java.security.cert.CertificateException {
    }
}
