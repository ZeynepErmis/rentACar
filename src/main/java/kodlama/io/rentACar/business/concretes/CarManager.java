package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstratcs.CarService;
import kodlama.io.rentACar.business.requests.CreateCarRequest;
import kodlama.io.rentACar.business.requests.UpdateCarRequest;
import kodlama.io.rentACar.business.responses.GetAllCarsResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.CarRepository;
import kodlama.io.rentACar.entities.concretes.Car;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class CarManager implements CarService {

	private ModelMapperService modelMapperService;
	private CarRepository carRepository;

	@Override
	public void add(CreateCarRequest createCarRequest) {
		Car car = modelMapperService.forRequest().map(createCarRequest, Car.class);
		carRepository.save(car);
	}

	@Override
	public void update(UpdateCarRequest updateCarRequest) {
		Car car = modelMapperService.forRequest().map(updateCarRequest, Car.class);
		carRepository.save(car);
	}

	@Override
	public void delete(int id) {
		carRepository.deleteById(id);
	}

	@Override
	public List<GetAllCarsResponse> getCarsResponse() {
		List<Car> cars = this.carRepository.findAll();

		List<GetAllCarsResponse> carsResponse = cars.stream()
				.map(car -> modelMapperService.forResponse().map(car, GetAllCarsResponse.class))
				.collect(Collectors.toList());

		return carsResponse;
	}

}
