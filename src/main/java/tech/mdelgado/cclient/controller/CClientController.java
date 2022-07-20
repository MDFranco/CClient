package tech.mdelgado.cclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tech.mdelgado.cclient.service.CClientService;
import tech.mdelgado.cclient.model.Client;

@RestController
public class CClientController {

    @Autowired
    CClientService cClientService;

    @PostMapping("/creacliente")
    public ResponseEntity<String> saveClient(@RequestBody Client client){
        String result = cClientService.addClient(client);

        return ResponseEntity.ok(result);
    }
}
