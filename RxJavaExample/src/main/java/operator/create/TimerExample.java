package operator.create;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import comm.CommUtil;
import comm.Log;
import io.reactivex.Observable;

/*
 * interval과 유사하지만 한번만 실행 
 * 일정 시간이 지난후 한개의 데이터를 발행하고  onComplete()이벤트가 발생
 */
public class TimerExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CommUtil.exampleStart();
		
		Observable<String> observable = Observable.timer(500, TimeUnit.MILLISECONDS).map(notUsed -> {
			String dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
			
			return dateFormat;
		});
		observable.subscribe(Log::it);
		CommUtil.sleep(1000);
	}

}
