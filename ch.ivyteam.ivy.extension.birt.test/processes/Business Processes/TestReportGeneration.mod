[Ivy]
[>Created: Wed May 01 13:54:59 CEST 2013]
1267039BBFA83D05 3.17 #module
>Proto >Proto Collection #zClass
Tn0 TestReportGeneration Big #zClass
Tn0 B #cInfo
Tn0 #process
Tn0 @TextInP .resExport .resExport #zField
Tn0 @TextInP .type .type #zField
Tn0 @TextInP .processKind .processKind #zField
Tn0 @TextInP .xml .xml #zField
Tn0 @TextInP .responsibility .responsibility #zField
Tn0 @AnnotationInP-0n ai ai #zField
Tn0 @MessageFlowInP-0n messageIn messageIn #zField
Tn0 @MessageFlowOutP-0n messageOut messageOut #zField
Tn0 @StartRequest f0 '' #zField
Tn0 @GridStep f1 '' #zField
Tn0 @CREATE_REPORT_DIALOG_BEAN f2 '' #zField
Tn0 @EndTask f3 '' #zField
Tn0 @PushWFArc f5 '' #zField
Tn0 @PushWFArc f6 '' #zField
Tn0 @PushWFArc f4 '' #zField
Tn0 @InfoButton f7 '' #zField
>Proto Tn0 Tn0 TestReportGeneration #zField
Tn0 f0 outLink start1.ivp #txt
Tn0 f0 type birtextensiontest.Data #txt
Tn0 f0 actionDecl 'birtextensiontest.Data out;' #txt
Tn0 f0 requestEnabled true #txt
Tn0 f0 triggerEnabled false #txt
Tn0 f0 callSignature start1() #txt
Tn0 f0 startName 'Test BIRT Extension' #txt
Tn0 f0 taskData '#
#Wed May 01 13:54:27 CEST 2013
.DESC=
.NAM=Test BIRT Extension
' #txt
Tn0 f0 caseData '#
#Wed Jan 27 17:46:21 CET 2010
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
Tn0 f0 showInStartList 1 #txt
Tn0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>start1</name>
        <nameStyle>6,5,7,9
</nameStyle>
    </language>
</elementInfo>
' #txt
Tn0 f0 @C|.responsibility Everybody #txt
Tn0 f0 219 51 26 26 14 0 #rect
Tn0 f0 @|StartRequestIcon #fIcon
Tn0 f1 actionDecl 'birtextensiontest.Data out;
' #txt
Tn0 f1 actionTable 'out=in;
' #txt
Tn0 f1 actionCode 'out.reportParas.put("pParameter1","Ich bin Parameter 1");
out.reportParas.put("pParameter2","Ich bin Parameter 2");
out.resultFile = new File("Testbericht.doc");' #txt
Tn0 f1 type birtextensiontest.Data #txt
Tn0 f1 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>Init Parmeters
and Result File</name>
        <nameStyle>30,9
</nameStyle>
    </language>
</elementInfo>
' #txt
Tn0 f1 214 108 36 24 20 -13 #rect
Tn0 f1 @|StepIcon #fIcon
Tn0 f2 @AbstractThirdPartyProgramInterface|type birtextensiontest.Data #txt
Tn0 f2 @AbstractThirdPartyProgramInterface|timeout 0 #txt
Tn0 f2 @AbstractThirdPartyProgramInterface|beanConfig """Testreport""|in.resultFile|ch.ivyteam.ivy.extension.birt.OutputFormat.DOC|in.reportParas|||" #txt
Tn0 f2 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
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
Tn0 f2 214 180 36 24 20 -2 #rect
Tn0 f2 @|CreateReportDialog #fIcon
Tn0 f3 type birtextensiontest.Data #txt
Tn0 f3 219 243 26 26 14 0 #rect
Tn0 f3 @|EndIcon #fIcon
Tn0 f5 expr out #txt
Tn0 f5 232 132 232 180 #arcP
Tn0 f6 expr out #txt
Tn0 f6 232 204 232 243 #arcP
Tn0 f4 expr out #txt
Tn0 f4 232 77 232 108 #arcP
Tn0 f7 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>Init Parameters and Result File

The result file will be saved in your Designer 
location under
files/application/TestReport.pdf</name>
        <nameStyle>128,9
</nameStyle>
    </language>
</elementInfo>
' #txt
Tn0 f7 345 75 254 90 -122 -40 #rect
Tn0 f7 @|IBIcon #fIcon
Tn0 f7 -14336|-1|-16777216 #nodeStyle
>Proto Tn0 .type birtextensiontest.Data #txt
>Proto Tn0 .processKind NORMAL #txt
>Proto Tn0 .xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <swimlaneLabel>Report Generation</swimlaneLabel>
        <swimlaneLabel></swimlaneLabel>
    </language>
    <swimlaneSize>502</swimlaneSize>
    <swimlaneColor>-6710785</swimlaneColor>
</elementInfo>
' #txt
>Proto Tn0 0 0 32 24 18 0 #rect
>Proto Tn0 @|BIcon #fIcon
Tn0 f1 mainOut f5 tail #connect
Tn0 f5 head f2 @AbstractThirdPartyProgramInterface|mainIn #connect
Tn0 f2 @AbstractThirdPartyProgramInterface|mainOut f6 tail #connect
Tn0 f6 head f3 mainIn #connect
Tn0 f0 mainOut f4 tail #connect
Tn0 f4 head f1 mainIn #connect
