package multithread;

class Incremenator extends Thread
{
	//О ключевом слове volatile - чуть ниже
	private  boolean mIsIncrement = true;
	private  boolean mFinish = false;

	public void changeAction()	//Меняет действие на противоположное
	{
		mIsIncrement = !mIsIncrement;
	}
	public void finish()		//Инициирует завершение потока
	{
		mFinish = true;
	}

	@Override
	public void run()
	{
		do
		{
			if(!mFinish)	//Проверка на необходимость завершения
			{
				if(mIsIncrement)	
					Programm1.mValue++;	//Инкремент
				else
					Programm1.mValue--;	//Декремент
				
				//Вывод текущего значения переменной
				System.out.print(Programm1.mValue + " ");
			}
			else
				return;		//Завершение потока

			try{
				Thread.sleep(1000);		//Приостановка потока на 1 сек.
			}catch(InterruptedException e){}
		}
		while(true); 
	}
}

public class Programm1
{
	//Переменая, которой оперирует инкременатор
	public volatile static int mValue = 0;
	
	static Incremenator mInc;	//Объект побочного потока

	public static void main(String[] args)
	{
		mInc = new Incremenator();	//Создание потока
		
		System.out.print("Значение = ");
		
		mInc.start();	//Запуск потока
		
		//Троекратное изменение действия инкременатора
		//с интервалом в i*2 секунд
		for(int i = 1; i <= 3; i++)
		{
			try{
				Thread.sleep(i*2*1000); //Ожидание в течении i*2 сек.
			}catch(InterruptedException e){}
			
			mInc.changeAction();	//Переключение действия
		}
		
		mInc.finish();	//Инициация завершения побочного потока	
	}
}
