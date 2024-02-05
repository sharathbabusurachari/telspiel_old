package com.saswath.telspiel.serviceImpl;

import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.saswath.telspiel.module.Telspiel;
import com.saswath.telspiel.service.SaswathService;

@Service
public class SaswathServiceImpl implements SaswathService {

	@Autowired
	RestTemplate restTemplate;

	@Override
	public String getSaswathStatus(Telspiel telspiel) {
		try {
			String baseURL = "https://api.telsp.in/pushapi/sendbulkmsg";
			String username = telspiel.getUsername();
			String dest = telspiel.getDest();
			String apikey = telspiel.getApikey();
			String signature = telspiel.getSignature();
			String msgtype = telspiel.getMsgtype();
			String msgtxt = telspiel.getMsgtxt();
			String entityid = telspiel.getEntityid();
			String templateid = telspiel.getTemplateid();

			String encodedMsgtxt = URLEncoder.encode(msgtxt, "UTF-8");
			String fullURL = String.format(
					"%s?username=%s&dest=%s&apikey=%s&signature=%s&msgtype=%s&msgtxt=%s&entityid=%s&templateid=%s",
					baseURL, username, dest, apikey, signature, msgtype, encodedMsgtxt, entityid, templateid);

			String responseEntity = restTemplate.getForObject(fullURL, String.class);

			return responseEntity;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}
 
}
