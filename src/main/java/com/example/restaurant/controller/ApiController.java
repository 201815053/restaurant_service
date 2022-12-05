package com.example.restaurant.controller;

import com.example.restaurant.wishlist.dto.WishListDto;
import com.example.restaurant.wishlist.service.WishListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/restaurant")
@RequiredArgsConstructor
public class ApiController {

    private final WishListService wishListService;

    @GetMapping("/search")
    public WishListDto search(@RequestParam String query){
        return wishListService.search(query);
    }

    @PostMapping("")
    public WishListDto add(@RequestBody WishListDto wishListDto){
        log.info("{}", wishListDto);
        return wishListService.add(wishListDto);
    }

    //dto 작성해서 add가 되는지 확인하기 위해 전체 list를 가져오는 list 구현
    //원했던 list의 결과를 findAll을 통해 내려감
    @GetMapping("/all")
    public List<WishListDto> findAll(){
        return wishListService.findAll();
    }

    //위시리스트 삭제
    @DeleteMapping("/{index}")
    public void delete(@PathVariable int index){
        wishListService.delete(index);
    }

    //방문횟수 추가
    @PostMapping("/{index}")
    public void addVisit(@PathVariable int index){
        wishListService.addVisit(index);
    }

}