# PRELUDE_PATH := vendor/prelude/js/src/prelude.clj
OUT_DIR := .github/bin
# SRC_DIRS := src test

# .PHONY: test
# test: build
# 	@ node $(OUT_DIR)/test/test.js

# .PHONY: build
# build:
# 	@ set -e; find $(SRC_DIRS) -name '*.clj' | while read clj_file; do \
# 		out_file=$(OUT_DIR)/$$(echo $$clj_file | sed 's|\.clj$$|.js|'); \
# 		mkdir -p $$(dirname $$out_file); \
# 		clj2js js $$clj_file $(PRELUDE_PATH) > $$out_file; \
# 	  done

.PHONY: test
test: build
# @ export OCAMLRUNPARAM=b && \
# 	cy2k -target eval -src src/test.clj
	@ node $(OUT_DIR)/test.js

.PHONY: build
build:
	@ export OCAMLRUNPARAM=b && \
		cy2k -target eval -src build.clj > .github/Makefile
	@ $(MAKE) -f .github/Makefile

.PHONY: clean
clean:
	@ rm -rf $(OUT_DIR)
