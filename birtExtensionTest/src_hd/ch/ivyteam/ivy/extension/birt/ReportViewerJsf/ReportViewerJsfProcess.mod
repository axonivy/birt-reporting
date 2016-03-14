[Ivy]
[>Created: Fri Mar 11 08:35:13 CET 2016]
1536499CAF76A4E6 3.18 #module
>Proto >Proto Collection #zClass
Rs0 ReportViewerJsfProcess Big #zClass
Rs0 RD #cInfo
Rs0 #process
Rs0 @TextInP .ui2RdDataAction .ui2RdDataAction #zField
Rs0 @TextInP .rdData2UIAction .rdData2UIAction #zField
Rs0 @TextInP .resExport .resExport #zField
Rs0 @TextInP .type .type #zField
Rs0 @TextInP .processKind .processKind #zField
Rs0 @AnnotationInP-0n ai ai #zField
Rs0 @MessageFlowInP-0n messageIn messageIn #zField
Rs0 @MessageFlowOutP-0n messageOut messageOut #zField
Rs0 @TextInP .xml .xml #zField
Rs0 @TextInP .responsibility .responsibility #zField
Rs0 @RichDialogInitStart f0 '' #zField
Rs0 @RichDialogProcessEnd f1 '' #zField
Rs0 @PushWFArc f2 '' #zField
Rs0 @RichDialogProcessStart f3 '' #zField
Rs0 @RichDialogEnd f4 '' #zField
Rs0 @PushWFArc f5 '' #zField
>Proto Rs0 Rs0 ReportViewerJsfProcess #zField
Rs0 f0 guid 1536499CB23F901C #txt
Rs0 f0 type ch.ivyteam.ivy.extension.birt.ReportViewerJsf.ReportViewerJsfData #txt
Rs0 f0 method start(String) #txt
Rs0 f0 disableUIEvents true #txt
Rs0 f0 inParameterDecl 'ch.ivyteam.ivy.richdialog.exec.RdMethodCallEvent methodEvent = event as ch.ivyteam.ivy.richdialog.exec.RdMethodCallEvent;
<java.lang.String reportUrl> param = methodEvent.getInputArguments();
' #txt
Rs0 f0 inParameterMapAction 'out.reportUrl=param.reportUrl;
' #txt
Rs0 f0 outParameterDecl '<> result;
' #txt
Rs0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>start(String)</name>
    </language>
</elementInfo>
' #txt
Rs0 f0 53 85 22 22 14 0 #rect
Rs0 f0 @|RichDialogInitStartIcon #fIcon
Rs0 f1 type ch.ivyteam.ivy.extension.birt.ReportViewerJsf.ReportViewerJsfData #txt
Rs0 f1 53 213 22 22 14 0 #rect
Rs0 f1 @|RichDialogProcessEndIcon #fIcon
Rs0 f2 expr out #txt
Rs0 f2 64 107 64 213 #arcP
Rs0 f3 guid 1536499CB378922A #txt
Rs0 f3 type ch.ivyteam.ivy.extension.birt.ReportViewerJsf.ReportViewerJsfData #txt
Rs0 f3 actionDecl 'ch.ivyteam.ivy.extension.birt.ReportViewerJsf.ReportViewerJsfData out;
' #txt
Rs0 f3 actionTable 'out=in;
' #txt
Rs0 f3 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>close</name>
    </language>
</elementInfo>
' #txt
Rs0 f3 149 85 22 22 14 0 #rect
Rs0 f3 @|RichDialogProcessStartIcon #fIcon
Rs0 f4 type ch.ivyteam.ivy.extension.birt.ReportViewerJsf.ReportViewerJsfData #txt
Rs0 f4 guid 1536499CB3882CD2 #txt
Rs0 f4 149 213 22 22 14 0 #rect
Rs0 f4 @|RichDialogEndIcon #fIcon
Rs0 f5 expr out #txt
Rs0 f5 160 107 160 213 #arcP
>Proto Rs0 .type ch.ivyteam.ivy.extension.birt.ReportViewerJsf.ReportViewerJsfData #txt
>Proto Rs0 .processKind HTML_DIALOG #txt
>Proto Rs0 -8 -8 16 16 16 26 #rect
>Proto Rs0 '' #fIcon
Rs0 f0 mainOut f2 tail #connect
Rs0 f2 head f1 mainIn #connect
Rs0 f3 mainOut f5 tail #connect
Rs0 f5 head f4 mainIn #connect
