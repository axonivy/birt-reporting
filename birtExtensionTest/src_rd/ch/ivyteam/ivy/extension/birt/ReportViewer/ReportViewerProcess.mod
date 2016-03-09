[Ivy]
[>Created: Fri Feb 19 07:43:45 CET 2010]
126E4E30038584D5 3.12 #module
>Proto >Proto Collection #zClass
Rs0 ReportViewerProcess Big #zClass
Rs0 RD #cInfo
Rs0 #process
Rs0 @MessageFlowInP-0n messageIn messageIn #zField
Rs0 @MessageFlowOutP-0n messageOut messageOut #zField
Rs0 @AnnotationInP-0n ai ai #zField
Rs0 @TextInP .xml .xml #zField
Rs0 @TextInP .responsibility .responsibility #zField
Rs0 @TextInP .resExport .resExport #zField
Rs0 @TextInP .type .type #zField
Rs0 @TextInP .processKind .processKind #zField
Rs0 @TextInP .ui2RdDataAction .ui2RdDataAction #zField
Rs0 @TextInP .rdData2UIAction .rdData2UIAction #zField
Rs0 @RichDialogInitStart f0 '' #zField
Rs0 @RichDialogProcessEnd f1 '' #zField
Rs0 @PushWFArc f2 '' #zField
Rs0 @RichDialogInitStart f3 '' #zField
Rs0 @InfoButton f5 '' #zField
Rs0 @GridStep f19 '' #zField
Rs0 @RichDialogInitStart f7 '' #zField
Rs0 @PushWFArc f8 '' #zField
Rs0 @PushWFArc f6 '' #zField
Rs0 @RichDialogProcessStart f9 '' #zField
Rs0 @Alternative f4 '' #zField
Rs0 @PushWFArc f10 '' #zField
Rs0 @RichDialogEnd f11 '' #zField
Rs0 @RichDialogProcessEnd f12 '' #zField
Rs0 @PushWFArc f15 '' #zField
Rs0 @PushWFArc f14 '' #zField
Rs0 @PushWFArc f13 '' #zField
>Proto Rs0 Rs0 ReportViewerProcess #zField
Rs0 f0 guid 126E4E30047A3E53 #txt
Rs0 f0 type ch.ivyteam.ivy.extension.birt.ReportViewer.ReportViewerData #txt
Rs0 f0 method start() #txt
Rs0 f0 disableUIEvents true #txt
Rs0 f0 inParameterDecl 'ch.ivyteam.ivy.richdialog.exec.RdMethodCallEvent methodEvent = event as ch.ivyteam.ivy.richdialog.exec.RdMethodCallEvent;
<> param = methodEvent.getInputArguments();
' #txt
Rs0 f0 outParameterDecl '<> result;
' #txt
Rs0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>start()</name>
    </language>
</elementInfo>
' #txt
Rs0 f0 90 40 20 20 13 0 #rect
Rs0 f0 @|RichDialogInitStartIcon #fIcon
Rs0 f1 type ch.ivyteam.ivy.extension.birt.ReportViewer.ReportViewerData #txt
Rs0 f1 90 140 20 20 13 0 #rect
Rs0 f1 @|RichDialogProcessEndIcon #fIcon
Rs0 f2 expr out #txt
Rs0 f2 100 60 100 140 #arcP
Rs0 f3 guid 126E4E4A4EFB76FF #txt
Rs0 f3 type ch.ivyteam.ivy.extension.birt.ReportViewer.ReportViewerData #txt
Rs0 f3 method showReport(String) #txt
Rs0 f3 disableUIEvents true #txt
Rs0 f3 inParameterDecl 'ch.ivyteam.ivy.richdialog.exec.RdMethodCallEvent methodEvent = event as ch.ivyteam.ivy.richdialog.exec.RdMethodCallEvent;
<java.lang.String reportUrl> param = methodEvent.getInputArguments();
' #txt
Rs0 f3 inParameterMapAction 'out.openExternalBrowser=false;
out.reportUrl=param.reportUrl;
' #txt
Rs0 f3 inActionCode 'ivy.log.info("Report URL: " + param.reportUrl);' #txt
Rs0 f3 outParameterDecl '<> result;
' #txt
Rs0 f3 embeddedRdInitializations '* ' #txt
Rs0 f3 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>showReport(String)</name>
        <nameStyle>18,5,7,9
</nameStyle>
    </language>
</elementInfo>
' #txt
Rs0 f3 182 46 20 20 13 0 #rect
Rs0 f3 @|RichDialogInitStartIcon #fIcon
Rs0 f5 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>See in Data Binding how the report url
is mapped with the Browser Widget</name>
        <nameStyle>72,9
</nameStyle>
    </language>
</elementInfo>
' #txt
Rs0 f5 76 187 217 42 -103 -16 #rect
Rs0 f5 @|IBIcon #fIcon
Rs0 f5 -14336|-1|-16777216 #nodeStyle
Rs0 f19 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>Preview report
in external
Browser</name>
        <nameStyle>34,9
</nameStyle>
        <desc>The Browser widget is not compatible with Windows 7 and Vista, therefore
all reports must be open in an external browser</desc>
    </language>
</elementInfo>
' #txt
Rs0 f19 actionDecl 'ch.ivyteam.ivy.extension.birt.ReportViewer.ReportViewerData out;
' #txt
Rs0 f19 actionTable 'out=in;
' #txt
Rs0 f19 actionCode com.ulcjava.base.application.ClientContext.showDocument(in.reportUrl); #txt
Rs0 f19 type ch.ivyteam.ivy.extension.birt.ReportViewer.ReportViewerData #txt
Rs0 f19 190 292 36 24 20 -13 #rect
Rs0 f19 @|StepIcon #fIcon
Rs0 f7 guid 126E4F2128E5BE33 #txt
Rs0 f7 type ch.ivyteam.ivy.extension.birt.ReportViewer.ReportViewerData #txt
Rs0 f7 method showReportInExternalBrowser(String) #txt
Rs0 f7 disableUIEvents true #txt
Rs0 f7 inParameterDecl 'ch.ivyteam.ivy.richdialog.exec.RdMethodCallEvent methodEvent = event as ch.ivyteam.ivy.richdialog.exec.RdMethodCallEvent;
<java.lang.String reportUrl> param = methodEvent.getInputArguments();
' #txt
Rs0 f7 inParameterMapAction 'out.openExternalBrowser=true;
out.reportUrl=param.reportUrl;
' #txt
Rs0 f7 outParameterDecl '<> result;
' #txt
Rs0 f7 embeddedRdInitializations '* ' #txt
Rs0 f7 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>showReportInExternalBrowser(String)</name>
        <nameStyle>35,5,7,9
</nameStyle>
    </language>
</elementInfo>
' #txt
Rs0 f7 350 46 20 20 13 0 #rect
Rs0 f7 @|RichDialogInitStartIcon #fIcon
Rs0 f8 expr out #txt
Rs0 f8 192 66 100 140 #arcP
Rs0 f8 1 192 103 #addKink
Rs0 f8 2 100 103 #addKink
Rs0 f8 1 0.5000000000000001 0 0 #arcLabel
Rs0 f6 expr out #txt
Rs0 f6 360 66 100 140 #arcP
Rs0 f6 1 360 103 #addKink
Rs0 f6 2 100 103 #addKink
Rs0 f6 1 0.5 0 0 #arcLabel
Rs0 f9 guid 126E4F560804C0F5 #txt
Rs0 f9 type ch.ivyteam.ivy.extension.birt.ReportViewer.ReportViewerData #txt
Rs0 f9 actionDecl 'ch.ivyteam.ivy.extension.birt.ReportViewer.ReportViewerData out;
' #txt
Rs0 f9 actionTable 'out=in;
' #txt
Rs0 f9 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>onLoad</name>
        <nameStyle>6,5,7,9
</nameStyle>
    </language>
</elementInfo>
' #txt
Rs0 f9 86 254 20 20 13 0 #rect
Rs0 f9 @|RichDialogProcessStartIcon #fIcon
Rs0 f4 type ch.ivyteam.ivy.extension.birt.ReportViewer.ReportViewerData #txt
Rs0 f4 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>show report
in external 
browser</name>
        <nameStyle>32,9
</nameStyle>
    </language>
</elementInfo>
' #txt
Rs0 f4 82 290 28 28 14 0 #rect
Rs0 f4 @|AlternativeIcon #fIcon
Rs0 f10 expr out #txt
Rs0 f10 96 274 96 290 #arcP
Rs0 f11 type ch.ivyteam.ivy.extension.birt.ReportViewer.ReportViewerData #txt
Rs0 f11 guid 126E4F66E3780EBA #txt
Rs0 f11 334 294 20 20 13 0 #rect
Rs0 f11 @|RichDialogEndIcon #fIcon
Rs0 f12 type ch.ivyteam.ivy.extension.birt.ReportViewer.ReportViewerData #txt
Rs0 f12 86 366 20 20 13 0 #rect
Rs0 f12 @|RichDialogProcessEndIcon #fIcon
Rs0 f15 expr out #txt
Rs0 f15 226 304 334 304 #arcP
Rs0 f14 expr in #txt
Rs0 f14 outCond in.openExternalBrowser #txt
Rs0 f14 110 304 190 304 #arcP
Rs0 f13 expr in #txt
Rs0 f13 96 318 96 366 #arcP
>Proto Rs0 .xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <swimlaneLabel>Start</swimlaneLabel>
        <swimlaneLabel></swimlaneLabel>
    </language>
    <swimlaneSize>792</swimlaneSize>
    <swimlaneColor>-6684775</swimlaneColor>
</elementInfo>
' #txt
>Proto Rs0 .type ch.ivyteam.ivy.extension.birt.ReportViewer.ReportViewerData #txt
>Proto Rs0 .processKind RICH_DIALOG #txt
>Proto Rs0 .rdData2UIAction 'panel.brReportViewer.url=in.reportUrl;
' #txt
>Proto Rs0 -8 -8 16 16 16 26 #rect
>Proto Rs0 '' #fIcon
Rs0 f0 mainOut f2 tail #connect
Rs0 f2 head f1 mainIn #connect
Rs0 f3 mainOut f8 tail #connect
Rs0 f8 head f1 mainIn #connect
Rs0 f7 mainOut f6 tail #connect
Rs0 f6 head f1 mainIn #connect
Rs0 f9 mainOut f10 tail #connect
Rs0 f10 head f4 in #connect
Rs0 f19 mainOut f15 tail #connect
Rs0 f15 head f11 mainIn #connect
Rs0 f4 out f14 tail #connect
Rs0 f14 head f19 mainIn #connect
Rs0 f4 out f13 tail #connect
Rs0 f13 head f12 mainIn #connect
