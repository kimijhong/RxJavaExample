package operator.combine;

import java.util.concurrent.TimeUnit;

import comm.CommUtil;
import comm.Log;
import comm.Shape;
import io.reactivex.Observable;

public class ZipExample {

	/*
	 * 2개이상의 Observable 결과를 합친다.
	 */

	public void emit() {
		String shapes[] = { "BALL", "PENTAGON", "STAR" };
		String coloredTriangles[] = { "2-T", "6-T", "4-T" };

		// Observable.fromArray(shapes).map(Shape::getSuffix).subscribe(Log::i);
		// Observable.fromArray(coloredTriangles).map(Shape::getColor).subscribe(Log::i);

		Observable<String> observable = Observable.zip(Observable.fromArray(shapes).map(Shape::getSuffix),
				Observable.fromArray(coloredTriangles).map(Shape::getColor),
				Observable.fromArray(shapes).map(Shape::getShape),
				(suffix, color, shape) -> color + suffix + " " + shape);

		observable.subscribe(Log::i);
	}

	public void zipNumber() {
		Observable<Integer> observable = Observable.zip(Observable.just(100, 200, 300)
				, Observable.just(10, 20, 30),
				  Observable.just(1, 2, 3), 
				(re1, re2,re3) -> {

					return re1 + re2 + re3;
				});

		observable.subscribe(Log::i);

	}
	
	public void zipInterval()
	{
	
		
		Observable<String> observable = Observable.zip(Observable.just(100, 200, 300)
				, Observable.just("RED", "GREEN", "BLUE")
				,Observable.interval(200L, TimeUnit.MILLISECONDS),
				(re1, re2,re3) -> {

					return re1 +" "+re2 + " time : "+ re3;
				});

		CommUtil.exampleStart();
		observable.subscribe(Log::i);
		CommUtil.sleep(2000);
	}

	public static void main(String[] args) {

		new ZipExample().zipInterval();
	}
}
