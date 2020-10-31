package com.mcw.mycarwash.Controller;

import com.mcw.mycarwash.Model.Advertiesments;
import com.mcw.mycarwash.Service.AdvertiesmenService;
import com.mcw.mycarwash.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/avdapi")
public class AdvertiesmentController {

    @Autowired
    private AdvertiesmenService advertiesmenService;

    @GetMapping("/advetiesment")
    public List<Advertiesments> getAdvertiesment() {
        return advertiesmenService.getAdvertiesmentList();
    }

    @PostMapping("/advetiesment")
    public Advertiesments save(@RequestBody Advertiesments advertiesments) {
        advertiesmenService.save_advertiesment(advertiesments);
        return advertiesments;
    }

    @GetMapping("/advetiesment/{id}")
    public Advertiesments getAdvetiesment(@PathVariable String id) {
        return advertiesmenService.get(id);
    }

}
