package tdea.construccion2.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tdea.construccion2.app.models.AppInfo;

@RestController
@RequestMapping("/api")
public class ApiInformation {
	
	@GetMapping("/info")
	public ResponseEntity<AppInfo> getInfo(){
		AppInfo appinfo =  new AppInfo();
		appinfo.setAppName("construccion2");
		return ResponseEntity.ok().body(appinfo);
	}

}
