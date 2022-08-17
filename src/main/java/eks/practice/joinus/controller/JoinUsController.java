package eks.practice.joinus.controller;

import eks.practice.joinus.entity.Member;
import eks.practice.joinus.repository.MemberRepository;
import eks.practice.joinus.restservice.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class JoinUsController {

    private static Logger logger = LoggerFactory.getLogger(JoinUsController.class);

    @Autowired
    private MemberService memberService;

//    @Operation(summary = "Health Check")
//    @ApiResponses({
//            @ApiResponse(
//                    description = "Health Check",
//                    responseCode = "200",
//                    content = {
//                            @Content(
//                                    schema = @Schema(
//                                            implementation = String.class,
//                                            description = "OK"
//                                    )
//                            )
//                    }
//            )
//    })
    @GetMapping("/health_check")
    public String index(){
        return "OK";
    }

//    @Operation(summary = "Join Us")
    @PostMapping("/joinus")
    @ResponseBody
    public String joinus(HttpServletRequest request, HttpServletResponse response, @RequestBody HashMap<String, Object> requestBodyMap) {

        if( requestBodyMap == null
                || requestBodyMap.get("loginId") == null
                || requestBodyMap.get("loginPwd") == null) throw new RuntimeException();

        Member requestMember = new Member();
        for (String key : requestBodyMap.keySet()) {
            switch (key){
                case "name":
                    requestMember.setName(requestBodyMap.get(key).toString());
                    break;
                case "loginId":
                    requestMember.setLoginId(requestBodyMap.get(key).toString());
                    break;
                case "loginPwd":
                    requestMember.setLoginPwd(requestBodyMap.get(key).toString());
                    break;
                case "telNo1":
                    requestMember.setTelNo1(requestBodyMap.get(key).toString());
                    break;
                case "telNo2":
                    requestMember.setTelNo2(requestBodyMap.get(key).toString());
                    break;
            }
        }
        Date currentDate = new Date();
        requestMember.setCreatedBy("FO Service");
        requestMember.setCreatedDt(currentDate);
        requestMember.setUpdatedBy("FO Service");
        requestMember.setUpdatedDt(currentDate);

        requestMember = memberService.saveMember(requestMember);
        logger.info(requestMember.toString());

        // TODO: 成功時、ログイン処理サービスを呼び出す

        return requestMember.getMemberSn();
    }

}
