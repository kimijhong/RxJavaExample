package operator.create;

import comm.Log;
import io.reactivex.Observable;

public class RepeatExample {

	/*
		�ܼ� �ݺ� ������ �Ѵ�.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String balls[] = {"1","2","3"};
		Observable<String> observable = Observable.fromArray(balls).repeat(3); //3���ݺ� ���ڸ� ���� ������ ���ѹݺ�
		observable.doOnComplete(()->{System.out.println("onComplete");}).subscribe(Log::it);
		
	}
	

}
