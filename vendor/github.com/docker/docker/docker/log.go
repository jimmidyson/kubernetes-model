package main

import (
	"io"

	"github.com/Sirupsen/logrus"
)

func setLogLevel(lvl logrus.Level) {
	logrus.SetLevel(lvl)
}

func initLogging(stderr io.Writer) {
	logrus.SetOutput(stderr)
}
