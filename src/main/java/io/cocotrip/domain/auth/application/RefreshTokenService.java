package io.cocotrip.domain.auth.application;

import io.cocotrip.domain.auth.persistence.RefreshToken;
import io.cocotrip.domain.auth.persistence.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * RefreshTokenService 리프레시 토큰을 다루는 서비스 클래스
 */
@RequiredArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@Service
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;

    //전체적인 exception 처리 필요

    /**
     * 리프레시 토큰을 받아서 해당 리프레시 토큰을 가진 RefreshToken 객체 반환
     *
     * @param refreshToken 리프레시 토큰
     * @return RefreshToken 객체
     */
    public RefreshToken findByRefreshToken(final String refreshToken) {
        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new IllegalArgumentException("해당 리프레시 토큰이 없습니다."));
    }
}
