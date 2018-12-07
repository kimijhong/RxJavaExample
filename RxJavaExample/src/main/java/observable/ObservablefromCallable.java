package observable;

import java.util.concurrent.Callable;

import io.reactivex.Observable;

public class ObservablefromCallable {
	
	public void basic()
	{
		
		/* 비동기 실행후 결과를 반환하는 인터페이스 */
		Callable<String> callable = new Callable<String>() {

			@Override
			public String call() throws Exception {
				Thread.sleep(1000);
				return "Hello Callable";
			}
		};

		
		Observable<String> observable = Observable.fromCallable(callable);
		observable.subscribe(data -> {
			System.out.println(data);
		});
	}
	
	public void lambda()
	{
		Callable<String> callable = () -> {
			Thread.sleep(1000);
			return "Hello Callable";
		};
		
		Observable<String> observable = Observable.fromCallable(callable);
		observable.subscribe(data -> {
			System.out.println(data);
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObservablefromCallable callable = new ObservablefromCallable();
		callable.basic();
		callable.lambda();
		
	}
	


	

}
