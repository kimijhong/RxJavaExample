package operator.create;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import comm.CommUtil;
import comm.Log;
import io.reactivex.Observable;

/*
 * interval�� ���������� �ѹ��� ���� 
 * ���� �ð��� ������ �Ѱ��� �����͸� �����ϰ�  onComplete()�̺�Ʈ�� �߻�
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
