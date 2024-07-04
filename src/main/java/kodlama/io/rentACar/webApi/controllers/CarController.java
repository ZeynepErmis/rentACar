package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.rentACar.business.abstratcs.CarService;
import kodlama.io.rentACar.business.requests.CreateCarRequest;
import kodlama.io.rentACar.business.requests.UpdateCarRequest;
import kodlama.io.rentACar.business.responses.GetAllCarsResponse;

@RestController
@RequestMapping("api/cars")
public class CarController {

	@Autowired
	private CarService carService;

	@PostMapping
	public void add(@RequestBody CreateCarRequest createCarRequest) {
		carService.add(createCarRequest);
	}

	@GetMapping
	public List<GetAllCarsResponse> getAll() {
		return carService.getCarsResponse();
	}

	@PutMapping
	public void update(@RequestBody UpdateCarRequest updateCarRequest) {
		carService.update(updateCarRequest);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		carService.delete(id);
	}
}
