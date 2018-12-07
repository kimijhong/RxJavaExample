package operator.transform;

import java.util.concurrent.TimeUnit;

import comm.CommUtil;
import comm.Log;
import io.reactivex.Observable;

public class ConcatMapExample {

	/*
	 * flatMap() �Լ��� ����ϴ� �������� �����Ͱ� ������� ó������� ���� �ִ�. �߰��� �����Ͱ� �����
	 * 
	 */

	public void marblediagram() {
		CommUtil.exampleStart();

		String balls[] = { "1", "3", "5" };
		Observable<String> observable = Observable.interval(100L, TimeUnit.MILLISECONDS).map(Long::intValue)
				.map(idx -> balls[idx]).take(balls.length)
				.concatMap(ball -> Observable.interval(200L, TimeUnit.MILLISECONDS).map(notUsed -> {
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

	public void interleaving() {
		String balls[] = { "1", "3", "5" };
		Observable<String> observable = Observable.interval(100L, TimeUnit.MILLISECONDS).map(Long::intValue)
				.map(idx -> balls[idx]).take(balls.length)
				.flatMap(ball -> Observable.interval(200L, TimeUnit.MILLISECONDS).map(notUsed -> {
					if (notUsed == 0) {
						return ball + "<>";
					}

					return ball + "**";
				})

						.take(2));
		observable.subscribe(Log::it);
		CommUtil.sleep(2000);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConcatMapExample concatMapExample = new ConcatMapExample();
		concatMapExample.marblediagram();
		concatMapExample.interleaving();
	}

}
