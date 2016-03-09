[Ivy]
[>Created: Wed May 01 13:54:59 CEST 2013]
126E4DD03DE98401 3.17 #module
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
>Proto Tw0 Tw0 TestReportPreview #zField
Tw0 f0 outLink start1.ivp #txt
Tw0 f0 type birtextensiontest.Data #txt
Tw0 f0 actionDecl 'birtextensiontest.Data out;' #txt
Tw0 f0 requestEnabled true #txt
Tw0 f0 triggerEnabled false #txt
Tw0 f0 callSignature start1() #txt
Tw0 f0 startName 'Preview persisent Reports' #txt
Tw0 f0 taskData '#
#Wed May 01 13:54:27 CEST 2013
.DESC=
.NAM=Preview persisent Reports
' #txt
Tw0 f0 caseData '#
#Fri Feb 19 07:15:43 CET 2010
businessMilestone.timestamp=
subType.code=
mainContact.id=
mainContact.name=
processCategory.name=
businessPriority=
processCategory.code=
mainContact.docDb.code=
mainContact.type=
businessObject.folder.id=
businessObject.docDb.code=
process.name=
businessCreator.user=
businessStart.timestamp=
process.code=
type.name=
businessObject.name=
type.code=
businessObject.code=
correspondent.id=
case.name=
mainContact.folder.id=
subType.name=
case.description=
' #txt
Tw0 f0 showInStartList 1 #txt
Tw0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>Preview
persistent Report
Files</name>
        <nameStyle>31,5,7,9
</nameStyle>
    </language>
</elementInfo>
' #txt
Tw0 f0 @C|.responsibility Everybody #txt
Tw0 f0 139 75 26 26 14 0 #rect
Tw0 f0 @|StartRequestIcon #fIcon
Tw0 f1 outLink start2.ivp #txt
Tw0 f1 type birtextensiontest.Data #txt
Tw0 f1 actionDecl 'birtextensiontest.Data out;' #txt
Tw0 f1 requestEnabled true #txt
Tw0 f1 triggerEnabled false #txt
Tw0 f1 callSignature start2() #txt
Tw0 f1 startName 'Preview temporary Reports' #txt
Tw0 f1 taskData '#
#Wed May 01 13:54:27 CEST 2013
.DESC=
.NAM=Preview temporary Reports
' #txt
Tw0 f1 caseData '#
#Fri Feb 19 07:16:03 CET 2010
businessMilestone.timestamp=
subType.code=
mainContact.id=
mainContact.name=
processCategory.name=
businessPriority=
processCategory.code=
mainContact.docDb.code=
mainContact.type=
businessObject.folder.id=
businessObject.docDb.code=
process.name=
businessCreator.user=
businessStart.timestamp=
process.code=
type.name=
businessObject.name=
type.code=
businessObject.code=
correspondent.id=
case.name=
mainContact.folder.id=
subType.name=
case.description=
' #txt
Tw0 f1 showInStartList 1 #txt
Tw0 f1 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>Preview
temporary
Reports</name>
        <nameStyle>25,5,7,9
</nameStyle>
    </language>
</elementInfo>
' #txt
Tw0 f1 @C|.responsibility Everybody #txt
Tw0 f1 507 83 26 26 14 0 #rect
Tw0 f1 @|StartRequestIcon #fIcon
Tw0 f2 actionDecl 'birtextensiontest.Data out;
' #txt
Tw0 f2 actionTable 'out=in;
' #txt
Tw0 f2 actionCode 'out.reportParas.put("pParameter1","Ich bin Parameter 1");
out.reportParas.put("pParameter2","Ich bin Parameter 2");
out.resultFile = new File("Testbericht.pdf");' #txt
Tw0 f2 type birtextensiontest.Data #txt
Tw0 f2 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>Init Parmeters
and Result File</name>
        <nameStyle>30,9
</nameStyle>
    </language>
</elementInfo>
' #txt
Tw0 f2 134 164 36 24 20 -13 #rect
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
Tw0 f3 502 172 36 24 20 -13 #rect
Tw0 f3 @|StepIcon #fIcon
Tw0 f4 expr out #txt
Tw0 f4 152 101 152 164 #arcP
Tw0 f5 expr out #txt
Tw0 f5 520 109 520 172 #arcP
Tw0 f6 @AbstractThirdPartyProgramInterface|type birtextensiontest.Data #txt
Tw0 f6 @AbstractThirdPartyProgramInterface|timeout 0 #txt
Tw0 f6 @AbstractThirdPartyProgramInterface|beanConfig """Testreport""|in.resultFile|ch.ivyteam.ivy.extension.birt.OutputFormat.PDF|in.reportParas|||" #txt
Tw0 f6 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>Generate
Report in
Result File</name>
        <nameStyle>30,9
</nameStyle>
    </language>
</elementInfo>
' #txt
Tw0 f6 134 236 36 24 20 -2 #rect
Tw0 f6 @|CreateReportDialog #fIcon
Tw0 f7 @AbstractThirdPartyProgramInterface|type birtextensiontest.Data #txt
Tw0 f7 @AbstractThirdPartyProgramInterface|timeout 0 #txt
Tw0 f7 @AbstractThirdPartyProgramInterface|beanConfig """Testreport""|in.resultFile|ch.ivyteam.ivy.extension.birt.OutputFormat.PDF|in.reportParas|||" #txt
Tw0 f7 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>Generate
Report in
Result File</name>
        <nameStyle>30,9
</nameStyle>
    </language>
</elementInfo>
' #txt
Tw0 f7 502 244 36 24 20 -2 #rect
Tw0 f7 @|CreateReportDialog #fIcon
Tw0 f8 expr out #txt
Tw0 f8 152 188 152 236 #arcP
Tw0 f9 expr out #txt
Tw0 f9 520 196 520 244 #arcP
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
Tw0 f10 134 316 36 24 20 -13 #rect
Tw0 f10 @|StepIcon #fIcon
Tw0 f11 expr out #txt
Tw0 f11 152 260 152 316 #arcP
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
Tw0 f12 502 324 36 24 20 -13 #rect
Tw0 f12 @|StepIcon #fIcon
Tw0 f13 expr out #txt
Tw0 f13 520 268 520 324 #arcP
Tw0 f14 targetWindow NEW:card: #txt
Tw0 f14 targetDisplay TOP #txt
Tw0 f14 richDialogId ch.ivyteam.ivy.extension.birt.ReportViewer #txt
Tw0 f14 startMethod showReportInExternalBrowser(String) #txt
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
Tw0 f14 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>Preview report
with Report Viewer
Dialog</name>
        <nameStyle>40,9
</nameStyle>
    </language>
</elementInfo>
' #txt
Tw0 f14 310 412 36 24 20 -2 #rect
Tw0 f14 @|RichDialogIcon #fIcon
Tw0 f15 expr out #txt
Tw0 f15 152 340 310 424 #arcP
Tw0 f15 1 152 424 #addKink
Tw0 f15 1 0.2341772151898735 0 0 #arcLabel
Tw0 f17 type birtextensiontest.Data #txt
Tw0 f17 315 483 26 26 14 0 #rect
Tw0 f17 @|EndIcon #fIcon
Tw0 f18 expr out #txt
Tw0 f18 328 436 328 483 #arcP
Tw0 f16 expr out #txt
Tw0 f16 520 348 346 424 #arcP
Tw0 f16 1 520 424 #addKink
Tw0 f16 1 0.28160919540229884 0 0 #arcLabel
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
