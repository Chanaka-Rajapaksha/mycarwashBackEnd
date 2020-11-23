package com.mcw.mycarwash.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mcw.mycarwash.Model.Client;
import com.mcw.mycarwash.Model.Customer;
import com.mcw.mycarwash.Model.ImageFile;
import com.mcw.mycarwash.Model.Location;
import com.mcw.mycarwash.Service.ClientService;
import com.mcw.mycarwash.Service.DocumentCodeService;
import com.mcw.mycarwash.ServiceImpl.ImageFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/cliapi")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ImageFileService fileStorageService;
    @Autowired
    private DocumentCodeService documentCodeService;


    @GetMapping("/client")
    public List<Client> getClientList() {
        return clientService.getClientList();
    }

    @PostMapping("/client")
    public Client save(@RequestParam("client") String model, @RequestParam("file") MultipartFile file) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        Client client = mapper.readValue(model, Client.class);
        String clientId = documentCodeService.nextDocNumber("client", "MCWCUS");
        String imageId = documentCodeService.nextDocNumber(clientId, "IMG");
        client.setClientId(clientId);
        client.setImageId(imageId);
        ImageFile fileName = fileStorageService.storeFile(file, imageId);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/getfileurl/")
                .path(fileName.getFileName())
                .toUriString();
        client.setImageURL(fileDownloadUri);
        clientService.saveClient(client);
        return client;
    }

    @GetMapping("/client/{id}")
    public Client getCustomer(@PathVariable String id) {
        return clientService.get(id);
    }

    @DeleteMapping("/client/{id}")
    public String deleteCustomer(@PathVariable String id) {
        clientService.deleteClient(id);
        return "Client deleted" + id;
    }

    @PostMapping("/getNearLocations")
    public List<Client> getNearestClientList(@RequestBody Location location) {
        return clientService.getNearClientList(location);
    }
}
