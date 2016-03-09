Birt Plugin am Designer installieren
====================================

1) Datei ch.ivyteam.ivy.extension.birt_1.0.0.jar in das Verzeichnis Designer/plugins installieren
2) Ec
3) Eclipse neu starten





   <extensionPoint interface="ch.ivyteam.ivy.server.IServerExtension" bundle="ch.ivyteam.ivy.extension.birt">
      <extension  bundle="ch.ivyteam.ivy.extension.birt" class="ch.ivyteam.ivy.extension.birt.BirtEngine"/>
   </extensionPoint>
   
   <extensionPoint interface="ch.ivyteam.ivy.java.IIvyProjectClassPathExtension" bundle="ch.ivyteam.ivy.extension.birt">
      <extension  bundle="ch.ivyteam.ivy.extension.birt" class="ch.ivyteam.ivy.extension.birt.BirtProjectClassPathExtension"/>
   </extensionPoint>



