package observable;

import java.util.concurrent.Callable;

import io.reactivex.Observable;

public class ObservablefromCallable {
	
	public void basic()
	{
		
		/* �񵿱� ������ ����� ��ȯ�ϴ� �������̽� */
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
