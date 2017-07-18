package multithread;

class Incremenator extends Thread
{
	//� �������� ����� volatile - ���� ����
	private  boolean mIsIncrement = true;
	private  boolean mFinish = false;

	public void changeAction()	//������ �������� �� ���������������
	{
		mIsIncrement = !mIsIncrement;
	}
	public void finish()		//���������� ���������� ������
	{
		mFinish = true;
	}

	@Override
	public void run()
	{
		do
		{
			if(!mFinish)	//�������� �� ������������� ����������
			{
				if(mIsIncrement)	
					Programm1.mValue++;	//���������
				else
					Programm1.mValue--;	//���������
				
				//����� �������� �������� ����������
				System.out.print(Programm1.mValue + " ");
			}
			else
				return;		//���������� ������

			try{
				Thread.sleep(1000);		//������������ ������ �� 1 ���.
			}catch(InterruptedException e){}
		}
		while(true); 
	}
}

public class Programm1
{
	//���������, ������� ��������� ������������
	public volatile static int mValue = 0;
	
	static Incremenator mInc;	//������ ��������� ������

	public static void main(String[] args)
	{
		mInc = new Incremenator();	//�������� ������
		
		System.out.print("�������� = ");
		
		mInc.start();	//������ ������
		
		//����������� ��������� �������� �������������
		//� ���������� � i*2 ������
		for(int i = 1; i <= 3; i++)
		{
			try{
				Thread.sleep(i*2*1000); //�������� � ������� i*2 ���.
			}catch(InterruptedException e){}
			
			mInc.changeAction();	//������������ ��������
		}
		
		mInc.finish();	//��������� ���������� ��������� ������	
	}
}
