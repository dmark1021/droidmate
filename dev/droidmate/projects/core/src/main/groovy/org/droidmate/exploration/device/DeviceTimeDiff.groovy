// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, jamrozik@st.cs.uni-saarland.de
//
// This file is part of the "DroidMate" project.
//
// www.droidmate.org
package org.droidmate.exploration.device

import groovy.util.logging.Slf4j
import org.droidmate.MonitorConstants
import org.droidmate.common.logcat.TimeFormattedLogcatMessage
import org.droidmate.device.IExplorableAndroidDevice
import org.droidmate.exceptions.DeviceException
import org.droidmate.exceptions.DeviceNeedsRebootException
import org.droidmate.logcat.ITimeFormattedLogcatMessage

import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * <p>
 * The device has different internal clock than the host machine. This class represents the time diff between the clocks.
 *
 * </p><p>
 * Use {@link DeviceTimeDiff#sync} on a device clock time to make it in sync with the host machine clock time.
 *
 * </p><p>
 * For example, if the device clock is 3 seconds into the future as compared to the host machine clock,
 * 3 seconds will be subtracted from the sync() input, {@code deviceTime}.
 *
 * </p>
 */
@Slf4j
public class DeviceTimeDiff implements IDeviceTimeDiff
{

  private final IExplorableAndroidDevice device

  private Duration diff = null

  DeviceTimeDiff(IExplorableAndroidDevice device)
  {
    this.device = device
  }

  @Override
  public LocalDateTime sync(LocalDateTime deviceTime) throws DeviceNeedsRebootException, DeviceException
  {
    assert deviceTime != null

    if (diff == null)
      diff = computeDiff(device)
    assert diff != null

    return deviceTime.minus(diff)
  }

  private Duration computeDiff(IExplorableAndroidDevice device) throws DeviceNeedsRebootException, DeviceException
  {
    LocalDateTime deviceTime = device.getCurrentTime()
    LocalDateTime now = LocalDateTime.now()
    Duration diff = Duration.between(now, deviceTime)

    def formatter = DateTimeFormatter.ofPattern(
      MonitorConstants.monitor_time_formatter_pattern, MonitorConstants.monitor_time_formatter_locale)
    String msg = "computeDiff(device) result:\n" +
      "Current time   : ${now.format(formatter)}\n" +
      "Device time    : ${deviceTime.format(formatter)}\n" +
      "Resulting diff : ${diff.toString()}"

    log.trace(msg)

    assert diff != null
    return diff
  }

  @Override
  List<ITimeFormattedLogcatMessage> syncMessages(List<ITimeFormattedLogcatMessage> messages) throws DeviceNeedsRebootException, DeviceException
  {
    return messages.collect {
      TimeFormattedLogcatMessage.from(
        this.sync(it.time),
        it.level, it.tag, it.pidString, it.messagePayload)
    }

  }

  @Override
  void reset()
  {
    diff = null
  }
}
