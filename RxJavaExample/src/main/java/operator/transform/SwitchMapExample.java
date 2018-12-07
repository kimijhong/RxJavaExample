package operator.transform;

import java.util.concurrent.TimeUnit;

import comm.CommUtil;
import comm.Log;
import io.reactivex.Observable;

public class SwitchMapExample {
	
	/*
	 * 여러개의 값이 발행되었을때 마지막 값만 처리하고 싶을떄 사용 
	 * 
	 *
	*/

	public void emit()
	{
		CommUtil.exampleStart();
		String balls[] = { "1", "3", "5" };
		Observable<String> observable = Observable.interval(100L, TimeUnit.MILLISECONDS).map(Long::intValue)
				.map(idx -> balls[idx]).take(balls.length)
				.switchMap(ball -> Observable.interval(200L, TimeUnit.MILLISECONDS).map(notUsed -> {
					if (notUsed == 0) {
						return ball + "<>";
					}

					return ball + "**";
				})
				.take(2))
				.doOnComplete(() -> {
					System.out.println("doOnComplete~");
				});
		observable.subscribe(Log::it);
		CommUtil.sleep(2000);
	}
	
	public void usingDoNect()
	{
		CommUtil.exampleStart();
		String balls[] = { "1", "3", "5" };
		Observable<String> observable = Observable.interval(100L, TimeUnit.MILLISECONDS).map(Long::intValue)
				.map(idx -> balls[idx]).take(balls.length)
				.doOnNext(Log::it)
				.switchMap(ball -> Observable.interval(200L, TimeUnit.MILLISECONDS).map(notUsed -> {
					if (notUsed == 0) {
						return ball + "<>";
					}

					return ball + "**";
				})
				.take(2))
				.doOnComplete(() -> {
					System.out.println("doOnComplete~");
				});
		observable.subscribe(Log::it);
		CommUtil.sleep(2000);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwitchMapExample example = new SwitchMapExample();
		example.emit();
		example.usingDoNect();
	}

}
