package com.ll.chatai.domain.chatRoom.controller;

import com.ll.chatai.domain.chatRoom.dto.ChatRoomDTO;
import com.ll.chatai.domain.chatRoom.dto.request.ChatRoomRequest;
import com.ll.chatai.domain.chatRoom.entity.ChatRoom;
import com.ll.chatai.domain.chatRoom.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/chat/rooms")
@CrossOrigin(
        origins = {"https://cdpn.io/","http://localhost:5173/","https://app-front-2501.vercel.app/"}
)
public class APIV1ChatRoomController {
    private final ChatRoomService chatRoomService;

    @GetMapping
    public List<ChatRoom> getRoomList(){
        List<ChatRoom> chatRooms= chatRoomService.findAll();

        List<ChatRoomDTO> chatRoomDTOList
                =chatRooms.stream()
                .map(chatRoom ->new ChatRoomDTO(chatRoom))
                .collect(Collectors.toList());

        return chatRooms;
    }

    @GetMapping("/{roomId}")
    public ChatRoom getRoom(@PathVariable("roomId") Long roomId){
        ChatRoom chatRoom=chatRoomService.find(roomId);
        if(chatRoom==null){
            return null;
        }
        return chatRoom;
    }

    @PostMapping
    public ChatRoom makeRoom(@RequestBody ChatRoomRequest request){
        ChatRoom chatRoom=chatRoomService.create(request.getName());
        return chatRoom;
    }
}
