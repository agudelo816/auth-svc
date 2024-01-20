package com.agudelo.service;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

@Service
public class SimpleLoginAttemptServiceImpl implements LoginAttemptService {

	private final int MAX_ATTEMPTS = 5;
	private final long LOCK_TIME_DURATION = 30; // lock time in minutes
	private final ConcurrentHashMap<String, Integer> attemptsCache = new ConcurrentHashMap<>();
	private final ConcurrentHashMap<String, LocalDateTime> lockTimeCache = new ConcurrentHashMap<>();

	public void loginSucceeded(String key) {
		this.attemptsCache.remove(key);
		this.lockTimeCache.remove(key);
	}

	public void loginFailed(String key) {
		int attempts = this.attemptsCache.getOrDefault(key, 0);
		attempts++;
		this.attemptsCache.put(key, attempts);
		if (attempts >= this.MAX_ATTEMPTS) {
			this.lockTimeCache.put(key, LocalDateTime.now());
		}
	}

	public boolean isBlocked(String key) {
		if (this.lockTimeCache.containsKey(key)) {
			final LocalDateTime lockTime = this.lockTimeCache.get(key);
			if (lockTime.plusMinutes(this.LOCK_TIME_DURATION).isAfter(LocalDateTime.now())) {
				return true; // User is still locked
			}
			this.lockTimeCache.remove(key); // Unlock after duration
			this.attemptsCache.remove(key); // Reset attempts
			return false;
		}
		return false;
	}

	public int getRemainingAttempts(String key) {
		return this.MAX_ATTEMPTS - this.attemptsCache.getOrDefault(key, 0);
	}
}
