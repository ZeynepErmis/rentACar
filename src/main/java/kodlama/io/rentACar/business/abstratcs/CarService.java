package kodlama.io.rentACar.business.abstratcs;

import java.util.List;

import kodlama.io.rentACar.business.requests.CreateCarRequest;
import kodlama.io.rentACar.business.requests.UpdateCarRequest;
import kodlama.io.rentACar.business.responses.GetAllCarsResponse;

public interface CarService {

	void add(CreateCarRequest createCarRequest);

	void update(UpdateCarRequest updateBrandRequest);

	void delete(int id);

	List<GetAllCarsResponse> getCarsResponse();

}
