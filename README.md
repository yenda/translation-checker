# translation-checker

Tool to check translation PRs for https://github.com/status-im/status-react

## Installation

Download from https://github.com/yenda/translation-checker/releases/download/0.1.0/translation-checker-0.1.0-standalone.jar

## Usage

On a PR go to the `files changed` tab, click the ``view`` button on the translation file then the `raw` button. Copy the URL of the raw file and use it as a filename for the following CLI:

    $ java -jar translation-checker-0.1.0-standalone.jar filename

You will get an output such as

```
Remove:  #{:whisper-identity}
Missing:  #{:status-sending}
```

or 

```
Translation looks OK
```
