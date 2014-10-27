package br.eti.jorgefilho.commons.ws.connect.rest;

import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;




public  class HttpConnectConfig {
	
	public static RestTemplate restTemplate(Integer readTimeout, Integer connectTimeout) {
        return new RestTemplate(clientHttpRequestFactory(readTimeout, connectTimeout));
    }	
	public static RestTemplate restTemplate(Integer connectTimeout) {
        return new RestTemplate(clientHttpRequestFactory(connectTimeout));
    }
    private static ClientHttpRequestFactory clientHttpRequestFactory(Integer readTimeout, Integer connectTimeout) {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setReadTimeout(readTimeout);
        factory.setConnectTimeout(connectTimeout);
        return factory;
    }
    private static ClientHttpRequestFactory clientHttpRequestFactory(Integer connectTimeout) {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();     
        factory.setConnectTimeout(connectTimeout);
        return factory;
    }
}