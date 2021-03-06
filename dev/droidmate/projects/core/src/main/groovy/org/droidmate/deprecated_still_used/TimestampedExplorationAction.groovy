// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, jamrozik@st.cs.uni-saarland.de
//
// This file is part of the "DroidMate" project.
//
// www.droidmate.org

package org.droidmate.deprecated_still_used

import groovy.transform.Canonical
import org.droidmate.exploration.actions.ExplorationAction

import java.time.LocalDateTime

@Deprecated
@Canonical
class TimestampedExplorationAction implements Serializable
{

  private static final long serialVersionUID = 1

  @Delegate
  ExplorationAction explorationAction

  LocalDateTime     timestamp

  static TimestampedExplorationAction from(ExplorationAction explorationAction, LocalDateTime timestamp)
  {
    return new TimestampedExplorationAction(explorationAction, timestamp)
  }


}

