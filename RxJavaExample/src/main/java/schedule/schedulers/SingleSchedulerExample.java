package schedule.schedulers;

import comm.CommUtil;
import comm.Log;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class SingleSchedulerExample {

	public void emit()
	{
		Observable<Integer> number = Observable.range(100, 5);
		Observable<String> chars = Observable.range(0, 5).map(CommUtil::numberToAlphabet);
		
		number.subscribeOn(Schedulers.single()).subscribe(Log::i);
		chars.subscribeOn(Schedulers.single()).subscribe(Log::i);
		
	
		CommUtil.sleep(500);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleSchedulerExample example = new SingleSchedulerExample();
		example.emit();
	}


}
