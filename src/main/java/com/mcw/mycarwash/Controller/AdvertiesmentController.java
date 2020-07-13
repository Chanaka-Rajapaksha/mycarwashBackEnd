package com.mcw.mycarwash.Controller;

import com.mcw.mycarwash.Model.Advertiesments;
import com.mcw.mycarwash.Service.AdvertiesmenService;
import com.mcw.mycarwash.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/avdapi")
public class AdvertiesmentController {

    @Autowired
    private AdvertiesmenService advertiesmenService;

    @Autowired
    private ClientService clientService;

    @GetMapping("/advetiesment")
    public Map getAdvertiesment() {
        //List ll = new ArrayList();
       // ll.add(advertiesmenService.getAdvertiesmentList());
        //ll.add(clientService.getClientList());
        Map<String, Object> result = new HashMap<String,Object>();
        result.put("adv",advertiesmenService.getAdvertiesmentList());
        result.put("client",clientService.getClientList());
        return result;
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
