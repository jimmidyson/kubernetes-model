package log

import log "github.com/inconshreveable/log15"

var Log = log.New()

func init() {
	Log.SetHandler(log.DiscardHandler())
}
