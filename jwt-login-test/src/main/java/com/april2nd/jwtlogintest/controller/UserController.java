package com.april2nd.jwtlogintest.controller;

import com.april2nd.jwtlogintest.dto.TokenRes;
import com.april2nd.jwtlogintest.dto.UserReq;
import com.april2nd.jwtlogintest.entity.User;
import com.april2nd.jwtlogintest.jwt.JwtTokenProvider;
import com.april2nd.jwtlogintest.repo.UserRepository;
import com.april2nd.jwtlogintest.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Api(value = "유저 API", tags = {"User"})
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    // 회원가입
    @PostMapping("/join")
    @ApiOperation(value = "회원 가입", notes = "<strong>아이디와 패스워드</strong>를 통해 회원가입 한다.")
    public ResponseEntity join(@RequestBody UserReq userRequest) {
        if(userService.findByUserId(userRequest.getUserId()).isPresent())
            return ResponseEntity.badRequest().build();
        else
            return ResponseEntity.ok(userService.register(userRequest));
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserReq userRequest) throws Exception {
        return ResponseEntity
                .ok()
                .body(userService.doLogin(userRequest));
    }

    @PostMapping("/user/test")
    public Map userResponseTest() {
        Map<String, String> result = new HashMap<>();
        result.put("result","success");
        return result;
    }

    //Access Token을 재발급 위한 api
    @PostMapping("/issue")
    public ResponseEntity issueAccessToken(HttpServletRequest request) throws Exception {
        return ResponseEntity
                .ok()
                .body(userService.issueAccessToken(request));
    }

    // refresh 토큰 대신 인덱스를 반환하는 회원가입
    @PostMapping("/joinindex")
    public ResponseEntity join2(@RequestBody UserReq userRequest) {
        if(userService.findByUserId(userRequest.getUserId()).isPresent())
            return ResponseEntity.badRequest().build();
        else
            return ResponseEntity.ok(userService.registerIndex(userRequest));
    }

    //Access Token을 재발급 위한 api (refresh 토큰 인덱스를 통한 재발급)
    @PostMapping("/issueindex")
    public ResponseEntity issueAccessToken2(HttpServletRequest request) throws Exception {
        return ResponseEntity
                .ok()
                .body(userService.issueAccessIndexToken(request));
    }
}
