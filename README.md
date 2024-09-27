# EatMyShorts
![Spigot](https://img.shields.io/badge/Spigot-1.21.1-yellow.svg)
![Paper](https://img.shields.io/badge/PaperMC-1.21.1-blue.svg)
![Version](https://img.shields.io/badge/Version-1.0-lightgray.svg)
![MIT License](https://img.shields.io/badge/License-MIT-green.svg)

**EatMyShorts** is a Spigot plugin that allows players to create shortcuts for commands in Minecraft. This plugin provides a convenient way to execute frequently used commands with customizable shortcuts, which can be executed either by players or the server.

## Features

- Define custom command shortcuts in `config.yml`.
- Execute commands as a player or through the server console.
- Support for command arguments.
- Easy to configure and extend.

## Installation

1. **Download the Plugin**: Download the latest version of the EatMyShorts plugin JAR file from the releases section.

2. **Place the Plugin in Your Server**: Move the downloaded JAR file into the `plugins` directory of your Spigot server.

3. **Start Your Server**: Launch your server. This will generate the `config.yml` file.

4. **Configure Shortcuts**: Edit the `config.yml` file to add your custom shortcuts. Here is an example configuration:

   ```yaml
   version: 1.0
   exampleshortcut:
     execute: player
     command: examplecommand
     useargs: true
   exampleshortcut2:
     execute: server
     command: examplecommand2
     useargs: false
´´´´

5. **Reload the Plugin:** After editing the ``config.yml``, reload the plugin using the ``/reload`` command or restart the server.

## Usage

To use a shortcut, simply type the shortcut command in the chat with a leading slash (/). For example:

To execute examplecommand, type:
```bash
/exampleshortcut
````

## Permissions
The following permission is required to execute player shortcuts:
``eatmyshorts.use``: Grants permission to use shortcuts defined for player execution.

## Configuration
The configuration file (``config.yml``) allows you to define shortcuts dynamically. Each shortcut entry must include:

- ``execute:`` Determines whether the command is executed as a player or server.
- ``command:`` The command that will be executed.
- ``useargs:`` A boolean value that indicates whether to use the arguments of the original command.

## Support
If you encounter any issues or have questions about the plugin, feel free to open an issue in the GitHub repository.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
