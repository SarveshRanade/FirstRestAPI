package com.sarvesh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sarvesh.domain.FirstDomain;
import com.sarvesh.repository.FirstRepository;
import com.sarvesh.service.FirstService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
@Api(value = "FirstControllerAPI")
public class FirstController {

	@Autowired
	FirstRepository firstRepository;

	@Autowired
	FirstService firstService;

	@GetMapping("/getAll")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "The POST call is Failed"),
			@ApiResponse(code = 404, message = "The API could not be found") })
	public ResponseEntity<List<FirstDomain>> getAll() {
		List<FirstDomain> list = firstRepository.findAll();
		return ResponseEntity.ok().body(list);

	}

	@GetMapping("/getbyId")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "The POST call is Failed"),
			@ApiResponse(code = 404, message = "The API could not be found") })
	public FirstDomain findbyId(int id) {

		return firstRepository.findbyid(id);
	}

	@PostMapping("/create")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "The POST call is Failed"),
			@ApiResponse(code = 404, message = "The API could not be found") })
	public ResponseEntity<FirstDomain> create(@Validated @RequestBody FirstDomain firstDomain) {
		System.out.println("---------------------------" + firstDomain);
		firstService.create(firstDomain);
		System.out.println("******************************************" + "Method Called");
		return ResponseEntity.ok().body(firstDomain);
	}

	@DeleteMapping("/delete")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "The POST call is Failed"),
			@ApiResponse(code = 404, message = "The API could not be found") })
	public void delete(@RequestParam int id) {
		System.out.println("++++++++++++++Delete Called+++++++++");
		FirstDomain domain = firstRepository.findbyid(id);
		firstRepository.delete(domain);
	}

	@PutMapping("/update")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "The POST call is Failed"),
			@ApiResponse(code = 404, message = "The API could not be found") })
	public ResponseEntity<FirstDomain> update(FirstDomain firstDomain) {
		firstRepository.save(firstDomain);
		return ResponseEntity.ok().body(firstDomain);
	}

}
