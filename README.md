# Axon.ivy BIRT extension
Provides BIRT report generation activities for the Axon.ivy Designer and allows it's execution on the Axon.ivy Engine.
<image src="https://github.com/ivy-supplements/birt-reporting/blob/master/birtExtension/techdoc/processEditorWithBirtExtension.png" width=300/>

## Documentation

### Installation
The installation procedure is exactly the same for Axon.ivy Designer and Engine. Therefore we're refer them as generic <i>Axon.ivy product</i> here.
1. Download the BIRT extension that matches your Axon.ivy product from our [releases](https://github.com/ivy-supplements/birt-reporting/releases) into the `dropins` directory of your Axon.ivy product.
2. Download the corresponding [birt-runtime-osgi](https://download.eclipse.org/birt/downloads/#runtime). Unpack the ZIP into a new `system/lib/birtRuntime` directory within the Axon.ivy product.
3. Create the `configuration/extensions/birt.properties` file. Within you have to set the `birtRuntime` property so that it references your unpacked runtime libraries. E.g.
`engineHome=system/lib/birtRuntime/ReportEngine/platform`

### Versions

|Axon.ivy |Birt Extension |Birt Runtime |Engine Home |
|---------|---------------|-------------|------------|
|>=7.4    |[7.4](https://github.com/ivy-supplements/birt-reporting/releases/latest) |[4.8.0](https://www.eclipse.org/downloads/download.php?file=/birt/downloads/drops/R-R1-4.8.0-201806261756/birt-runtime-osgi-4.8.0-20180626.zip) |`engineHome=system/lib/birtRuntime/birt-runtime-osgi-4_8_0/ReportEngine/platform` |
|6.7..7.3 |[6.7](https://github.com/ivy-supplements/birt-reporting/releases/tag/6.7.0) |[4.2.2](http://www.eclipse.org/downloads/download.php?file=/birt/downloads/drops/R-R1-4_2_2-201302161152/birt-runtime-osgi-4_2_2.zip) | `engineHome=system/lib/birtRuntime/birt-runtime-osgi-4_2_2/ReportEngine` |
|6.6      |[6.6](https://github.com/ivy-supplements/birt-reporting/releases/tag/6.6.0) |[4.2.2](http://www.eclipse.org/downloads/download.php?file=/birt/downloads/drops/R-R1-4_2_2-201302161152/birt-runtime-osgi-4_2_2.zip) | `engineHome=system/lib/birtRuntime/birt-runtime-osgi-4_2_2/ReportEngine` |
|< 6.5    |[6.0](https://github.com/ivy-supplements/birt-reporting/releases/tag/6.0.0) |[4.2.2](http://www.eclipse.org/downloads/download.php?file=/birt/downloads/drops/R-R1-4_2_2-201302161152/birt-runtime-osgi-4_2_2.zip) | `engineHome=system/lib/birtRuntime/birt-runtime-osgi-4_2_2/ReportEngine` |

### Design a report
To design reports you can choose one of these tools:

- RCP Designer **(recommended)**: a dedicated tool for designing reports. [Download](http://www.eclipse.org/downloads/download.php?file=/birt/downloads/drops/R-R1-4.6.0-201606072112/birt-rcp-report-designer-4.6.0-20160607-win32.win32.x86_64.zip) s
- Eclipse IDE for Java and Report Developers: a standalone reporting tool which contains also the full Eclipse SDK. [Download](https://www.eclipse.org/downloads/packages/eclipse-ide-java-and-report-developers/neonr)
- BIRT Framework Plugin for Eclipse [Download](http://www.eclipse.org/downloads/download.php?file=/birt/downloads/drops/R-R1-4.6.0-201606072112/birt-runtime-4.6.0-20160607.zip)
Plugin to design reports directly in the Axon.ivy Designer. Just download and unzip it to the designer directory (skip already existing files).

### Integrate Databases
All database drivers (e.g. the mysql-connector.jar for MySql) used in the report must be placed in the JDBC folder of the report engine. E.g.
`system/lib/birtRuntime/birt-runtime-osgi-4_2_2/ReportEngine/plugins/org.eclipse.birt.report.data.oda.jdbc_4.2.2.v201212061427/drivers/`

### Legacy
An outdated documentation is available. Some parts of it are no longer valid for the latest version. [birtExtension/techdoc/IvyBirtPluginGuide_en.pdf](https://github.com/ivy-supplements/birt-reporting/blob/master/birtExtension/techdoc/IvyBirtPluginGuide_en.pdf)
