package io.github.dps0340.paramstoquerydslexample;

import io.github.dps0340.paramstoquerydslexample.entity.Car;
import io.github.dps0340.paramstoquerydslexample.entity.Company;
import io.github.dps0340.paramstoquerydslexample.repository.CarRepository;
import io.reactivex.rxjava3.core.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CarRepository carRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Observable<String> companyNames = Observable.just("현대", "기아", "아우디", "벤츠", "BMW", "테슬라");
		Observable<Company> companyObservable = companyNames.map(name -> Company.builder().name(name).build());

		Observable<String> carNames = Observable.just("쏘나타", "K5", "A8", "S클래스", "i8", "모델 X");
		Observable<Car> carObservable = carNames.zipWith(companyObservable, (name, company) -> Car.builder().name(name).company(company).build());

		carObservable.subscribe(carRepository::save);
	}
}
