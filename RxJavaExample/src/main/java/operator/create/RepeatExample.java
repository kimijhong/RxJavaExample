package operator.create;

import comm.Log;
import io.reactivex.Observable;

public class RepeatExample {

	/*
		단순 반복 실행을 한다.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String balls[] = {"1","2","3"};
		Observable<String> observable = Observable.fromArray(balls).repeat(3); //3번반복 숫자를 넣지 않으면 무한반복
		observable.doOnComplete(()->{System.out.println("onComplete");}).subscribe(Log::it);
		
	}
	

}
