package com.website.service;

import org.springframework.scheduling.annotation.Scheduled;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DeployHookScheduler {

	private static final String DEPLOY_HOOK_URL = "https://api.render.com/deploy/srv-cuuqt82j1k6c73a13mmg?key=HWvPC5lB6og";

	private final RestTemplate restTemplate;

	public DeployHookScheduler(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	// Schedule the task to run every 30 minutes
	@Scheduled(cron = "0 */20 * * * *") // Every 30 minutes
	public void callDeployHook() {
		try {
			restTemplate.postForObject(DEPLOY_HOOK_URL, null, String.class);
			System.out.println("callDeployHook() Every 20 mins called");
		} catch (Exception e) {
			System.out.println("callDeployHook() Exception");
		}
	}

	@Scheduled(cron = "0 * * * * *") // Every 1 minute
	public void callDeployHookOneMinute() {
		try {
			restTemplate.postForObject(DEPLOY_HOOK_URL, null, String.class);
			System.out.println("callDeployHookOneMinute()");
		} catch (Exception e) {
			System.out.println("callDeployHookOneMinute() Exception");

		}
	}

}
