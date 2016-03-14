[Ivy]
[>Created: Fri Mar 11 10:04:23 CET 2016]
126E4DD03DE98401 3.18 #module
>Proto >Proto Collection #zClass
Tw0 TestReportPreview Big #zClass
Tw0 B #cInfo
Tw0 #process
Tw0 @MessageFlowInP-0n messageIn messageIn #zField
Tw0 @MessageFlowOutP-0n messageOut messageOut #zField
Tw0 @AnnotationInP-0n ai ai #zField
Tw0 @TextInP .xml .xml #zField
Tw0 @TextInP .responsibility .responsibility #zField
Tw0 @TextInP .resExport .resExport #zField
Tw0 @TextInP .type .type #zField
Tw0 @TextInP .processKind .processKind #zField
Tw0 @StartRequest f0 '' #zField
Tw0 @StartRequest f1 '' #zField
Tw0 @GridStep f2 '' #zField
Tw0 @GridStep f3 '' #zField
Tw0 @PushWFArc f4 '' #zField
Tw0 @PushWFArc f5 '' #zField
Tw0 @CREATE_REPORT_DIALOG_BEAN f6 '' #zField
Tw0 @CREATE_REPORT_DIALOG_BEAN f7 '' #zField
Tw0 @PushWFArc f8 '' #zField
Tw0 @PushWFArc f9 '' #zField
Tw0 @GridStep f10 '' #zField
Tw0 @PushWFArc f11 '' #zField
Tw0 @GridStep f12 '' #zField
Tw0 @PushWFArc f13 '' #zField
Tw0 @RichDialog f14 '' #zField
Tw0 @PushWFArc f15 '' #zField
Tw0 @EndTask f17 '' #zField
Tw0 @PushWFArc f18 '' #zField
Tw0 @PushWFArc f16 '' #zField
Tw0 @StartRequest f19 '' #zField
Tw0 @PushWFArc f20 '' #zField
>Proto Tw0 Tw0 TestReportPreview #zField
Tw0 f0 outLink start1.ivp #txt
Tw0 f0 type birtextensiontest.Data #txt
Tw0 f0 inParamTable 'out.reportFormat=ch.ivyteam.ivy.extension.birt.OutputFormat.PDF;
out.resultFile=new File("Testbericht.pdf");
' #txt
Tw0 f0 actionDecl 'birtextensiontest.Data out;
' #txt
Tw0 f0 requestEnabled true #txt
Tw0 f0 triggerEnabled false #txt
Tw0 f0 callSignature start1() #txt
Tw0 f0 persist false #txt
Tw0 f0 startName 'View persistent PDF' #txt
Tw0 f0 taskData 'TaskTriggered.ROL=Everybody
TaskTriggered.EXTYPE=0
.DESC=
TaskTriggered.EXPRI=2
TaskTriggered.TYPE=0
TaskTriggered.PRI=2
.NAM=Preview persisent Reports
TaskTriggered.EXROL=Everybody' #txt
Tw0 f0 showInStartList 1 #txt
Tw0 f0 taskAndCaseSetupAction 'import ch.ivyteam.ivy.workflow.TaskUpdateDefinition;
ch.ivyteam.ivy.workflow.TaskUpdateDefinition taskUpdDef = new ch.ivyteam.ivy.workflow.TaskUpdateDefinition();
import ch.ivyteam.ivy.request.impl.DefaultCalendarProxy;
DefaultCalendarProxy calendarProxy = ivy.cal as DefaultCalendarProxy;
taskUpdDef.setPriority(ch.ivyteam.ivy.workflow.WorkflowPriority.valueOf(2));
taskUpdDef.setExpiryActivator("Everybody");
taskUpdDef.setExpiryPriority(ch.ivyteam.ivy.workflow.WorkflowPriority.valueOf(2));
engine.updateCurrentTask(taskUpdDef);
' #txt
Tw0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>View
persistent Report
(PDF)</name>
        <nameStyle>28,5,7,9
</nameStyle>
    </language>
</elementInfo>
' #txt
Tw0 f0 @C|.responsibility Everybody #txt
Tw0 f0 171 75 26 26 14 0 #rect
Tw0 f0 @|StartRequestIcon #fIcon
Tw0 f1 outLink start2.ivp #txt
Tw0 f1 type birtextensiontest.Data #txt
Tw0 f1 inParamTable 'out.reportFormat=ch.ivyteam.ivy.extension.birt.OutputFormat.PDF;
' #txt
Tw0 f1 actionDecl 'birtextensiontest.Data out;
' #txt
Tw0 f1 requestEnabled true #txt
Tw0 f1 triggerEnabled false #txt
Tw0 f1 callSignature start2() #txt
Tw0 f1 persist false #txt
Tw0 f1 startName 'View temporary Report (PDF)' #txt
Tw0 f1 taskData 'TaskTriggered.ROL=Everybody
TaskTriggered.EXTYPE=0
.DESC=
TaskTriggered.EXPRI=2
TaskTriggered.TYPE=0
TaskTriggered.PRI=2
.NAM=Preview temporary Reports
TaskTriggered.EXROL=Everybody' #txt
Tw0 f1 showInStartList 1 #txt
Tw0 f1 taskAndCaseSetupAction 'import ch.ivyteam.ivy.workflow.TaskUpdateDefinition;
ch.ivyteam.ivy.workflow.TaskUpdateDefinition taskUpdDef = new ch.ivyteam.ivy.workflow.TaskUpdateDefinition();
import ch.ivyteam.ivy.request.impl.DefaultCalendarProxy;
DefaultCalendarProxy calendarProxy = ivy.cal as DefaultCalendarProxy;
taskUpdDef.setPriority(ch.ivyteam.ivy.workflow.WorkflowPriority.valueOf(2));
taskUpdDef.setExpiryActivator("Everybody");
taskUpdDef.setExpiryPriority(ch.ivyteam.ivy.workflow.WorkflowPriority.valueOf(2));
engine.updateCurrentTask(taskUpdDef);
' #txt
Tw0 f1 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>View 
temporary Report 
(PDF)</name>
        <nameStyle>29,5,7,9
</nameStyle>
    </language>
</elementInfo>
' #txt
Tw0 f1 @C|.responsibility Everybody #txt
Tw0 f1 483 75 26 26 14 0 #rect
Tw0 f1 @|StartRequestIcon #fIcon
Tw0 f2 actionDecl 'birtextensiontest.Data out;
' #txt
Tw0 f2 actionTable 'out=in;
' #txt
Tw0 f2 actionCode 'out.reportParas.put("pParameter1","Ich bin Parameter 1");
out.reportParas.put("pParameter2","Ich bin Parameter 2");' #txt
Tw0 f2 type birtextensiontest.Data #txt
Tw0 f2 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>Init Parmeters</name>
        <nameStyle>14,7,9
</nameStyle>
    </language>
</elementInfo>
' #txt
Tw0 f2 166 164 36 24 20 -13 #rect
Tw0 f2 @|StepIcon #fIcon
Tw0 f3 actionDecl 'birtextensiontest.Data out;
' #txt
Tw0 f3 actionTable 'out=in;
' #txt
Tw0 f3 actionCode 'out.reportParas.put("pParameter1","Ich bin Parameter 1");
out.reportParas.put("pParameter2","Ich bin Parameter 2");
//Use true as second parameter for temporary files
out.resultFile = new File("Testbericht.pdf", true);' #txt
Tw0 f3 type birtextensiontest.Data #txt
Tw0 f3 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>Init Parmeters
and Result File</name>
        <nameStyle>30,9
</nameStyle>
    </language>
</elementInfo>
' #txt
Tw0 f3 478 164 36 24 20 -13 #rect
Tw0 f3 @|StepIcon #fIcon
Tw0 f4 expr out #txt
Tw0 f4 184 101 184 164 #arcP
Tw0 f5 expr out #txt
Tw0 f5 496 101 496 164 #arcP
Tw0 f6 @AbstractThirdPartyProgramInterface|type birtextensiontest.Data #txt
Tw0 f6 @AbstractThirdPartyProgramInterface|timeout 0 #txt
Tw0 f6 @AbstractThirdPartyProgramInterface|beanConfig """Testreport""|in.resultFile|in.reportFormat|in.reportParas||" #txt
Tw0 f6 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>Generate
Report in
Result File</name>
        <nameStyle>30,7,9
</nameStyle>
    </language>
</elementInfo>
' #txt
Tw0 f6 166 236 36 24 20 -2 #rect
Tw0 f6 @|CreateReportDialog #fIcon
Tw0 f7 @AbstractThirdPartyProgramInterface|type birtextensiontest.Data #txt
Tw0 f7 @AbstractThirdPartyProgramInterface|timeout 0 #txt
Tw0 f7 @AbstractThirdPartyProgramInterface|beanConfig """Testreport""|in.resultFile|in.reportFormat|in.reportParas||" #txt
Tw0 f7 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>Generate
Report in
Result File</name>
        <nameStyle>30,7,9
</nameStyle>
    </language>
</elementInfo>
' #txt
Tw0 f7 478 236 36 24 20 -2 #rect
Tw0 f7 @|CreateReportDialog #fIcon
Tw0 f8 expr out #txt
Tw0 f8 184 188 184 236 #arcP
Tw0 f9 expr out #txt
Tw0 f9 496 188 496 236 #arcP
Tw0 f10 actionDecl 'birtextensiontest.Data out;
' #txt
Tw0 f10 actionTable 'out=in;
' #txt
Tw0 f10 actionCode 'out.reportUrl = ivy.html.fileref(in.resultFile);' #txt
Tw0 f10 type birtextensiontest.Data #txt
Tw0 f10 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>Prepare
report
url</name>
        <nameStyle>18,9
</nameStyle>
    </language>
</elementInfo>
' #txt
Tw0 f10 166 332 36 24 20 -13 #rect
Tw0 f10 @|StepIcon #fIcon
Tw0 f11 expr out #txt
Tw0 f11 184 260 184 332 #arcP
Tw0 f12 actionDecl 'birtextensiontest.Data out;
' #txt
Tw0 f12 actionTable 'out=in;
' #txt
Tw0 f12 actionCode '//Temporary files need the jsessionid
out.reportUrl = ivy.html.fileref(in.resultFile) +
                ";jsessionid=" + ivy.session.getHttpSessionIdentifier();' #txt
Tw0 f12 type birtextensiontest.Data #txt
Tw0 f12 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>Prepare
report
url</name>
        <nameStyle>18,9
</nameStyle>
    </language>
</elementInfo>
' #txt
Tw0 f12 478 332 36 24 20 -13 #rect
Tw0 f12 @|StepIcon #fIcon
Tw0 f13 expr out #txt
Tw0 f13 496 260 496 332 #arcP
Tw0 f14 targetWindow NEW:card: #txt
Tw0 f14 targetDisplay TOP #txt
Tw0 f14 richDialogId ch.ivyteam.ivy.extension.birt.ReportViewerJsf #txt
Tw0 f14 startMethod start(String) #txt
Tw0 f14 type birtextensiontest.Data #txt
Tw0 f14 requestActionDecl '<String reportUrl> param;' #txt
Tw0 f14 requestMappingAction 'param.reportUrl=in.reportUrl;
' #txt
Tw0 f14 responseActionDecl 'birtextensiontest.Data out;
' #txt
Tw0 f14 responseMappingAction 'out=in;
' #txt
Tw0 f14 windowConfiguration '{/title "Report Preview"/width 0 /height 0 /centered true /resizable true /maximized false /close_after_last_rd true }' #txt
Tw0 f14 isAsynch false #txt
Tw0 f14 isInnerRd false #txt
Tw0 f14 isDialog false #txt
Tw0 f14 userContext '* ' #txt
Tw0 f14 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>View report
with Report Viewer
Dialog</name>
        <nameStyle>37,7,9
</nameStyle>
    </language>
</elementInfo>
' #txt
Tw0 f14 310 412 36 24 20 -2 #rect
Tw0 f14 @|RichDialogIcon #fIcon
Tw0 f15 expr out #txt
Tw0 f15 184 356 310 424 #arcP
Tw0 f15 1 184 424 #addKink
Tw0 f15 1 0.2341772151898735 0 0 #arcLabel
Tw0 f17 type birtextensiontest.Data #txt
Tw0 f17 315 483 26 26 14 0 #rect
Tw0 f17 @|EndIcon #fIcon
Tw0 f18 expr out #txt
Tw0 f18 328 436 328 483 #arcP
Tw0 f16 expr out #txt
Tw0 f16 496 356 346 424 #arcP
Tw0 f16 1 496 424 #addKink
Tw0 f16 1 0.28160919540229884 0 0 #arcLabel
Tw0 f19 outLink viewHtmlReport.ivp #txt
Tw0 f19 type birtextensiontest.Data #txt
Tw0 f19 inParamDecl '<> param;' #txt
Tw0 f19 inParamTable 'out.reportFormat=ch.ivyteam.ivy.extension.birt.OutputFormat.HTML;
out.resultFile=new File("Testbericht.html");
' #txt
Tw0 f19 actionDecl 'birtextensiontest.Data out;
' #txt
Tw0 f19 guid 15364BE45479F267 #txt
Tw0 f19 requestEnabled true #txt
Tw0 f19 triggerEnabled false #txt
Tw0 f19 callSignature viewHtmlReport() #txt
Tw0 f19 persist false #txt
Tw0 f19 startName 'View persistent Report (HTML)' #txt
Tw0 f19 taskData 'TaskTriggered.ROL=Everybody
TaskTriggered.EXTYPE=0
TaskTriggered.EXPRI=2
TaskTriggered.TYPE=0
TaskTriggered.PRI=2
TaskTriggered.EXROL=Everybody' #txt
Tw0 f19 showInStartList 1 #txt
Tw0 f19 taskAndCaseSetupAction 'import ch.ivyteam.ivy.workflow.TaskUpdateDefinition;
ch.ivyteam.ivy.workflow.TaskUpdateDefinition taskUpdDef = new ch.ivyteam.ivy.workflow.TaskUpdateDefinition();
import ch.ivyteam.ivy.request.impl.DefaultCalendarProxy;
DefaultCalendarProxy calendarProxy = ivy.cal as DefaultCalendarProxy;
taskUpdDef.setPriority(ch.ivyteam.ivy.workflow.WorkflowPriority.valueOf(2));
taskUpdDef.setExpiryActivator("Everybody");
taskUpdDef.setExpiryPriority(ch.ivyteam.ivy.workflow.WorkflowPriority.valueOf(2));
engine.updateCurrentTask(taskUpdDef);
' #txt
Tw0 f19 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>View 
persistent Report
(HTML)</name>
        <nameStyle>30,5,7
</nameStyle>
    </language>
</elementInfo>
' #txt
Tw0 f19 @C|.responsibility Everybody #txt
Tw0 f19 35 75 26 26 14 0 #rect
Tw0 f19 @|StartRequestIcon #fIcon
Tw0 f20 expr out #txt
Tw0 f20 48 101 166 176 #arcP
Tw0 f20 1 48 176 #addKink
Tw0 f20 1 0.05667520337426348 0 0 #arcLabel
>Proto Tw0 .xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <swimlaneLabel>Preview with 
persistent 
Report Files</swimlaneLabel>
        <swimlaneLabel>Preview with
temporary
Report Files</swimlaneLabel>
        <swimlaneLabel></swimlaneLabel>
    </language>
    <swimlaneSize>326</swimlaneSize>
    <swimlaneSize>395</swimlaneSize>
    <swimlaneColor>-6710785</swimlaneColor>
    <swimlaneColor>-26215</swimlaneColor>
</elementInfo>
' #txt
>Proto Tw0 .type birtextensiontest.Data #txt
>Proto Tw0 .processKind NORMAL #txt
>Proto Tw0 0 0 32 24 18 0 #rect
>Proto Tw0 @|BIcon #fIcon
Tw0 f0 mainOut f4 tail #connect
Tw0 f4 head f2 mainIn #connect
Tw0 f1 mainOut f5 tail #connect
Tw0 f5 head f3 mainIn #connect
Tw0 f2 mainOut f8 tail #connect
Tw0 f8 head f6 @AbstractThirdPartyProgramInterface|mainIn #connect
Tw0 f3 mainOut f9 tail #connect
Tw0 f9 head f7 @AbstractThirdPartyProgramInterface|mainIn #connect
Tw0 f6 @AbstractThirdPartyProgramInterface|mainOut f11 tail #connect
Tw0 f11 head f10 mainIn #connect
Tw0 f7 @AbstractThirdPartyProgramInterface|mainOut f13 tail #connect
Tw0 f13 head f12 mainIn #connect
Tw0 f10 mainOut f15 tail #connect
Tw0 f15 head f14 mainIn #connect
Tw0 f14 mainOut f18 tail #connect
Tw0 f18 head f17 mainIn #connect
Tw0 f12 mainOut f16 tail #connect
Tw0 f16 head f14 mainIn #connect
Tw0 f19 mainOut f20 tail #connect
Tw0 f20 head f2 mainIn #connect
