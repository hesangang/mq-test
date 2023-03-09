[General]
MacroID=b246560a-4c6a-455d-a3b2-2db9ae90db65
SyntaxVersion=2
BeginHotkey=121
BeginHotkeyMod=0
PauseHotkey=0
PauseHotkeyMod=0
StopHotkey=123
StopHotkeyMod=0
RunOnce=1
EnableWindow=
Description=��¼�ƵĽű�2
Enable=1
AutoRun=0
[Repeat]
Type=0
Number=1
[SetupUI]
Type=2
QUI=
[Relative]
SetupOCXFile=
[Comment]

[Script]
'==========�����ǰ�������¼�Ƶ�����==========

//ѭ��ִ��
Delay 3000
DimEnv start
start=2
DimEnv key
key=0
DimEnv t
//ѭ��ʱ��Ƶ��
t=600
//��������
size=10
//ѭ������
i=0
BeginThread Thread1
While start=2
    Delay 10
Wend
While True
    Call PressYQ()
Wend
EndScript

//ִ��һȦ,i�Ƕ��ٸ�,y���������
Sub PressYQ()
    While i<size
        Call PressYG()
        i=i+1
        If (i=size)
            i=0
            KeyDown "PageUp", 1
            Delay 5
            KeyUp "PageUp", 1
            Delay 3
            KeyDown "PageUp", 1
            Delay 6
            KeyUp "PageUp", 1
            Delay 2
        EndIf
    Wend
End Sub
//ִ��һ������
Sub PressYG()
    Delay t
    KeyPress "F9", 1
    Delay 10
    //KeyUp "F9", 1
    //Delay 5
    KeyPress "Enter", 1
    Delay 15
    //KeyUp "Enter", 1
    //Delay 6
    KeyPress "Enter", 1
    Delay 15
    //KeyUp "Enter", 1
    //Delay 4
    KeyPress "Down", 1
    //Delay 2
    //KeyUp "Down", 1
End Sub

Sub PressQX()
    Delay t
    KeyPress "F9", 1
    Delay 10
    KeyPress 27, 1
    Delay 15
    KeyPress "Down", 1
End Sub

Sub Thread1()
    While True
        Key=WaitKey()
        SayString Key
        If (key=49)
            t=t-10
            SayString t
        ElseIf key=50
            t=t+10
            SayString t
        ElseIf key=51
            t=t-1
            SayString t
        ElseIf key=52
            t=t+1
            SayString t
        ElseIf key=48
            start=1
        EndIf
    Wend
End Sub

'==========�����ǰ�������¼�Ƶ�����==========
