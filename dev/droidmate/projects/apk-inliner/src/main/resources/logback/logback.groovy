// Copyright (c) 2013-2015 Saarland University
// All right reserved.
//
// Author: Konrad Jamrozik, jamrozik@st.cs.uni-saarland.de
//
// This file is part of the "DroidMate" project.
//
// www.droidmate.org

import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.classic.filter.LevelFilter
import ch.qos.logback.classic.filter.ThresholdFilter
import ch.qos.logback.core.ConsoleAppender
import org.droidmate.common.logging.AllDroidmateMarkersFilter

import static ch.qos.logback.classic.Level.ERROR
import static ch.qos.logback.classic.Level.TRACE
import static ch.qos.logback.core.spi.FilterReply.DENY
import static ch.qos.logback.core.spi.FilterReply.NEUTRAL

final String layoutPatternHaving_levLogEx = "%-5level %-40logger{40} - %msg%rEx%n"

// =======================================================
// Console appenders
// =======================================================

appender("stdout_appender", ConsoleAppender) {
  target = "System.out"
  filter(LevelFilter) {level = ERROR; onMatch = DENY; onMismatch = NEUTRAL}
  filter(AllDroidmateMarkersFilter) {onMatch = DENY}
  encoder(PatternLayoutEncoder) {pattern = layoutPatternHaving_levLogEx}
}

appender("stderr_appender", ConsoleAppender) {
  target = "System.err"
  filter(ThresholdFilter) {level = ERROR}
  encoder(PatternLayoutEncoder) {pattern = layoutPatternHaving_levLogEx}
}

root(TRACE, [
  "stdout_appender",
  "stderr_appender"

])
