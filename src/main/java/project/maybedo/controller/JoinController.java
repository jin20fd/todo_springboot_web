package project.maybedo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.maybedo.controller.dto.ResponseDto;
import project.maybedo.domain.Member;
import project.maybedo.service.GroupService;

import javax.naming.InsufficientResourcesException;
import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
public class JoinController {

    private final GroupService groupService;

    @PostMapping("/group/join/{group_id}")
    public ResponseDto<Integer> joinGroup(@PathVariable int group_id, HttpSession session)
    {
        Member member = (Member)session.getAttribute("principal");
        groupService.joinGroup(group_id, member);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
}
