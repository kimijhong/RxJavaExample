package schedule.schedulers;

import comm.CommUtil;
import comm.Log;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class TrampolineSchedulerExample {

	public void emit()
	{
		String orgs[] = {"1","3","5"};
		Observable.fromArray(orgs)
		.map(data -> "<<" + data + ">>")
		.subscribeOn(Schedulers.trampoline())
		.subscribe(Log::i);
		//CommUtil.sleep(500);
		
		
		Observable.fromArray(orgs)
		.map(data -> "##" + data + "##")
		.subscribeOn(Schedulers.trampoline())
		.subscribe(Log::i);
		CommUtil.sleep(500);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrampolineSchedulerExample example = new TrampolineSchedulerExample();
		example.emit();
	}

}
