[Ivy]
1267039BBFA83D05 3.23 #module
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
Tn0 f0 outLink pdf.ivp #txt
Tn0 f0 type birtextensiontest.Data #txt
Tn0 f0 actionDecl 'birtextensiontest.Data out;
' #txt
Tn0 f0 requestEnabled true #txt
Tn0 f0 triggerEnabled false #txt
Tn0 f0 callSignature pdf() #txt
Tn0 f0 persist false #txt
Tn0 f0 startName 'Test BIRT Extension (PDF)' #txt
Tn0 f0 taskData 'TaskTriggered.ROL=Everybody
TaskTriggered.EXTYPE=0
.DESC=
TaskTriggered.EXPRI=2
TaskTriggered.TYPE=0
TaskTriggered.PRI=2
.NAM=Test BIRT Extension
TaskTriggered.EXROL=Everybody' #txt
Tn0 f0 showInStartList 1 #txt
Tn0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>pdf</name>
        <nameStyle>3,5,7,9
</nameStyle>
    </language>
</elementInfo>
' #txt
Tn0 f0 @C|.responsibility Everybody #txt
Tn0 f0 67 75 26 26 14 0 #rect
Tn0 f0 @|StartRequestIcon #fIcon
Tn0 f1 actionDecl 'birtextensiontest.Data out;
' #txt
Tn0 f1 actionTable 'out=in;
' #txt
Tn0 f1 actionCode 'out.reportParas.put("pParameter1","Ich bin Parameter 1");
out.reportParas.put("pParameter2","Ich bin Parameter 2");
out.resultFile = new File("Testbericht.doc");

ivy.log.info("reporting into: "+ out.resultFile.getAbsolutePath());' #txt
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
Tn0 f1 62 132 36 24 20 -13 #rect
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
Tn0 f2 62 204 36 24 20 -2 #rect
Tn0 f2 @|CreateReportDialog #fIcon
Tn0 f3 type birtextensiontest.Data #txt
Tn0 f3 67 267 26 26 14 0 #rect
Tn0 f3 @|EndIcon #fIcon
Tn0 f5 expr out #txt
Tn0 f5 80 156 80 204 #arcP
Tn0 f6 expr out #txt
Tn0 f6 80 228 80 267 #arcP
Tn0 f4 expr out #txt
Tn0 f4 80 101 80 132 #arcP
Tn0 f7 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>Init Parameters and Result File

The result file will be saved in your Designer 
location under
files/application/TestReport.pdf/.html</name>
        <nameStyle>134,7,9
</nameStyle>
    </language>
</elementInfo>
' #txt
Tn0 f7 24 330 256 92 -122 -40 #rect
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
    <swimlaneSize>464</swimlaneSize>
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
